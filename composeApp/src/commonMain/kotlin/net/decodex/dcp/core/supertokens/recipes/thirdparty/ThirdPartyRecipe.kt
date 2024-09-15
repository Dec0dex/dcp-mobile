package net.decodex.dcp.core.supertokens.recipes.thirdparty

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.thirdparty.repositories.PkceRepository
import net.decodex.dcp.core.supertokens.recipes.thirdparty.repositories.PkceRepositoryImpl
import net.decodex.dcp.core.supertokens.recipes.thirdparty.usecases.GetThirdPartyAuthUrlUseCase
import net.decodex.dcp.core.supertokens.recipes.thirdparty.usecases.ThirdPartyAuthCodeSignInUseCase
import net.decodex.dcp.core.supertokens.recipes.thirdparty.usecases.ThirdPartyTokenSignInUseCase

fun <C : ProviderConfig, R : Provider<C>> ThirdPartyConfig.provider(
    builder: ProviderBuilder<C, R>,
    configure: C.() -> Unit = {},
) {
    +builder.install(configure)
}

class ThirdPartyConfig : RecipeConfig {
    var providers: List<BuildProvider> = emptyList()
        private set

    operator fun BuildProvider.unaryPlus() {
        providers = providers + this
    }

    var pkceRepository: PkceRepository? = null
}

class ThirdPartyRecipe(
    private val superTokens: SuperTokensClient,
    private val config: ThirdPartyConfig,
) : Recipe<ThirdPartyConfig> {
    private val providers: List<Provider<*>> = config.providers.map { it.invoke(superTokens, this) }

    val pkceRepository by lazy { config.pkceRepository ?: PkceRepositoryImpl() }

    private val thirdPartyAuthCodeSignInUseCase by lazy {
        ThirdPartyAuthCodeSignInUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            userRepository = superTokens.userRepository,
        )
    }

    private val thirdPartyTokenSignInUseCase by lazy {
        ThirdPartyTokenSignInUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            userRepository = superTokens.userRepository,
        )
    }

    private val getThirdPartyAuthUrlUseCase by lazy {
        GetThirdPartyAuthUrlUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    fun getProviderById(id: String): Provider<*> = providers.first { it.id == id }

    suspend fun thirdPartyAuthCodeSignIn(
        providerId: String,
        redirectURI: String,
        redirectURIQueryParams: Map<String, String>,
        clientType: String? = null,
    ) =
        thirdPartyAuthCodeSignInUseCase.signIn(
            providerId = providerId,
            pkceCodeVerifier = pkceRepository.getPkceCodeVerifier(providerId),
            redirectURI = redirectURI,
            redirectURIQueryParams = redirectURIQueryParams,
            clientType = clientType,
        )

    suspend fun thirdPartyTokenSignIn(
        providerId: String,
        accessToken: String,
        idToken: String?,
        clientType: String? = null,
    ) =
        thirdPartyTokenSignInUseCase.signIn(
            providerId = providerId,
            accessToken = accessToken,
            idToken = idToken,
            clientType = clientType,
        )

    suspend fun getAuthUrl(providerId: String) =
        getThirdPartyAuthUrlUseCase.getAuthUrl(
            provider = getProviderById(providerId),
        )
}

object ThirdParty : RecipeBuilder<ThirdPartyConfig, ThirdPartyRecipe>() {
    override fun install(
        configure: ThirdPartyConfig.() -> Unit,
    ): (SuperTokensClient) -> ThirdPartyRecipe {
        val config = ThirdPartyConfig().apply(configure)

        return { ThirdPartyRecipe(it, config) }
    }
}

suspend fun SuperTokensClient.getThirdPartyAuthorizationUrl(providerId: String): String {
    return getRecipe<ThirdPartyRecipe>().getAuthUrl(providerId = providerId)
}
