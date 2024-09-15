package net.decodex.dcp.core.supertokens.recipes.session

import io.ktor.client.HttpClientConfig
import io.ktor.client.call.HttpClientCall
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.Sender
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerAuthProvider
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.plugin
import io.ktor.client.plugins.pluginOrNull
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.HEADER_ACCESS_TOKEN
import net.decodex.dcp.core.supertokens.common.HEADER_REFRESH_TOKEN
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthRepository
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthRepositoryImpl
import net.decodex.dcp.core.supertokens.recipes.session.repository.ClaimsRepository
import net.decodex.dcp.core.supertokens.recipes.session.repository.ClaimsRepositorySettings
import net.decodex.dcp.core.supertokens.recipes.session.repository.TokensRepository
import net.decodex.dcp.core.supertokens.recipes.session.repository.TokensRepositorySettings
import net.decodex.dcp.core.supertokens.recipes.session.usecases.LogoutUseCase
import net.decodex.dcp.core.supertokens.recipes.session.usecases.RefreshTokensUseCase
import net.decodex.dcp.core.supertokens.recipes.session.usecases.UpdateAccessTokenUseCase
import net.decodex.dcp.core.supertokens.recipes.session.usecases.UpdateRefreshTokenUseCase

class SessionRecipeConfig : RecipeConfig {
    var authRepository: AuthRepository? = null
    var tokensRepository: TokensRepository? = null
    var claimsRepository: ClaimsRepository? = null

    var cookiesStorage: CookiesStorage? = null

    var refreshTokensOnStart: Boolean = true
}

class SessionRecipe(
    internal val superTokens: SuperTokensClient,
    private val config: SessionRecipeConfig,
) : Recipe<SessionRecipeConfig> {
    val authRepository: AuthRepository by lazy { config.authRepository ?: AuthRepositoryImpl() }
    val tokensRepository: TokensRepository by lazy {
        config.tokensRepository ?: TokensRepositorySettings(settings = superTokens.settings)
    }
    val claimsRepository: ClaimsRepository by lazy {
        config.claimsRepository ?: ClaimsRepositorySettings(
            settings = superTokens.settings, scope = superTokens.scope,
        )
    }

    internal val refreshTokensUseCase by lazy {
        RefreshTokensUseCase(
            sessionRecipe = this,
        )
    }

    internal val updateAccessTokenUseCase by lazy {
        UpdateAccessTokenUseCase(sessionRecipe = this)
    }

    internal val updateRefreshTokenUseCase by lazy {
        UpdateRefreshTokenUseCase(sessionRecipe = this)
    }

    internal val logoutUseCase by lazy {
        LogoutUseCase(sessionRecipe = this, userRepository = superTokens.userRepository)
    }

    override suspend fun postInit() {
        superTokens.apiClient.plugin(HttpSend).intercept(tokenHeaderInterceptor())

        tokensRepository.getRefreshToken()?.let {
            claimsRepository.getClaims()?.let { claims -> authRepository.setLoggedIn(claims.sub) }

            if (config.refreshTokensOnStart) {
                runCatching { refreshTokens() }.onFailure { it.printStackTrace() }
            }
        }
    }

    /**
     * Clears tokens from the http client. They will then be re-initialized on the next request.
     */
    internal fun clearClientTokens() {
        with(superTokens.apiClient) {
            pluginOrNull(Auth)?.let { bearerAuth ->
                bearerAuth.providers.filterIsInstance<BearerAuthProvider>().forEach { provider ->
                    provider.clearToken()
                }
            }
        }
    }

    suspend fun refreshTokens(): BearerTokens? =
        refreshTokensUseCase.refreshTokens(superTokens.apiClient)

    override fun HttpClientConfig<*>.configureClient() {
        install(HttpCookies) {
            storage = config.cookiesStorage ?: defaultCookieStorage(
                sessionRecipe = this@SessionRecipe,
            )
        }

        install(Auth) {
            bearer {
                loadTokens {
                    tokensRepository.getRefreshToken()?.let {
                        BearerTokens(tokensRepository.getAccessToken() ?: "", it)
                    }
                }

                refreshTokens { refreshTokensUseCase.refreshTokens(this) }
            }
        }
    }

    private fun tokenHeaderInterceptor(): suspend Sender.(HttpRequestBuilder) -> HttpClientCall =
        { request ->
            execute(request).also {
                if (it.response.status == HttpStatusCode.OK) {
                    it.response.headers[HEADER_ACCESS_TOKEN]?.let { token ->
                        if (token.isNotBlank()) {
                            updateAccessTokenUseCase.updateAccessToken(token)
                        } else if (!it.request.url.fullPath.endsWith(SuperTokensRoutes.Session.SIGN_OUT)) {
                            signOut(clearServerSession = false)
                        }
                    }

                    it.response.headers[HEADER_REFRESH_TOKEN]?.let { token ->
                        if (token.isNotBlank()) {
                            updateRefreshTokenUseCase.updateRefreshToken(token)
                        } else if (!it.request.url.fullPath.endsWith(SuperTokensRoutes.Session.SIGN_OUT)) {
                            signOut(clearServerSession = false)
                        }
                    }
                }
            }
        }

    suspend fun signOut(clearServerSession: Boolean = true) =
        logoutUseCase.signOut(clearServerSession = clearServerSession)
}

object Session : RecipeBuilder<SessionRecipeConfig, SessionRecipe>() {
    override fun install(
        configure: SessionRecipeConfig.() -> Unit,
    ): (SuperTokensClient) -> SessionRecipe {
        val config = SessionRecipeConfig().apply(configure)

        return { SessionRecipe(it, config) }
    }
}

suspend fun SuperTokensClient.signOut(clearServerSession: Boolean = true) =
    getRecipe<SessionRecipe>().signOut(clearServerSession = clearServerSession)
