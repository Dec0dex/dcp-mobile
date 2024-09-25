package net.decodex.dcp.core.supertokens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import net.decodex.dcp.core.constants.AppConfig.API_TIMEOUT
import net.decodex.dcp.core.supertokens.recipes.BuildRecipe
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepository
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepositoryImpl
import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthRepository
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthState
import net.decodex.dcp.core.supertokens.recipes.session.repository.ClaimsRepository
import net.decodex.dcp.core.supertokens.recipes.session.repository.TokensRepository

@SuperTokensDslMarker
class SuperTokensClientConfig(
    val apiBaseUrl: String,
    val dataStore: DataStore<Preferences>,
    val engine: HttpClientEngine,
    val logLevel: LogLevel,
) {
    var tenantId: String? = null

    var clientName: String = "DcpApp"

    var userRepository: SuperTokensUserRepository? = null

    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    var recipes: List<BuildRecipe> = emptyList()
        private set

    operator fun BuildRecipe.unaryPlus() {
        recipes = recipes + this
    }

    fun <C : RecipeConfig, R : Recipe<C>> recipe(
        builder: RecipeBuilder<C, R>,
        configure: C.() -> Unit = {},
    ) {
        +builder.install(configure)
    }

    @OptIn(ExperimentalSerializationApi::class)
    var client: HttpClient =
        HttpClient(engine) {
            install(Logging) {
                level = logLevel
                logger =
                    object : Logger {
                        override fun log(message: String) {
                            println(message) // Use platform-specific logging if needed
                        }
                    }
            }
            install(HttpTimeout) {
                socketTimeoutMillis = API_TIMEOUT
                requestTimeoutMillis = API_TIMEOUT
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        explicitNulls = false
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                    },
                )
            }
        }
}

class SuperTokensClient(
    private val config: SuperTokensClientConfig,
) {
    internal val scope: CoroutineScope
        get() = config.scope

    val tenantId: String?
        get() = config.tenantId

    val settings: DataStore<Preferences> by lazy { config.dataStore }

    val recipes: List<Recipe<*>> = config.recipes.map { it.invoke(this) }

    val apiClient by lazy {
        config.client.config {
            recipes.forEach { with(it) { configureClient() } }

            defaultRequest {
                url(config.apiBaseUrl)
                contentType(ContentType.Application.Json)
                header(HttpHeaders.Origin, config.clientName)
            }
        }
    }

    val authRepository: AuthRepository
        get() = getRecipe<SessionRecipe>().authRepository

    val userRepository: SuperTokensUserRepository by lazy {
        config.userRepository
            ?: SuperTokensUserRepositoryImpl(
                settings = settings,
                scope = scope,
            )
    }

    val tokenRepository: TokensRepository
        get() = getRecipe<SessionRecipe>().tokensRepository

    val claimsRepository: ClaimsRepository
        get() = getRecipe<SessionRecipe>().claimsRepository

    private val _isInitialized = MutableStateFlow(false)
    val isInitialized = _isInitialized.asStateFlow()

    inline fun <reified T : Recipe<*>> getRecipe(): T =
        recipes.filterIsInstance<T>().firstOrNull()
            ?: throw RuntimeException("Recipe ${T::class.simpleName} not configured")

    inline fun <reified T : Recipe<*>> hasRecipe(): Boolean =
        recipes.filterIsInstance<T>().isNotEmpty()

    /**
     * true, if the the user is at least logged in (but may not be authenticated from the backend yet)
     * It essentially means, there is a refresh token present, but no access token yet, e.g. during
     * startup when a new access token hasn't been fetched yet.
     */
    fun isLoggedIn(): Boolean = authRepository.authState.value !is AuthState.Unauthenticated

    // true, if the user was authenticated from the backend (an access token is present)
    fun isAuthenticated(): Boolean = authRepository.authState.value is AuthState.Authenticated

    init {
        scope.launch {
            recipes.forEach { recipe -> recipe.postInit() }
            _isInitialized.value = true
        }
    }
}

fun superTokensClient(
    apiBaseUrl: String,
    engine: HttpClientEngine,
    dataStore: DataStore<Preferences>,
    logLevel: LogLevel = LogLevel.ALL,
    init: SuperTokensClientConfig.() -> Unit = {},
): SuperTokensClient {
    val config =
        SuperTokensClientConfig(
            apiBaseUrl = apiBaseUrl,
            dataStore = dataStore,
            engine = engine,
            logLevel = logLevel,
        ).apply(init)
    return SuperTokensClient(config)
}
