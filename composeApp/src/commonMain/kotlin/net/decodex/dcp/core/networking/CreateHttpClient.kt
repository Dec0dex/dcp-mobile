package net.decodex.dcp.core.networking

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import net.decodex.dcp.core.constants.ApiRoutes
import net.decodex.dcp.core.constants.AppConfig
import net.decodex.dcp.core.constants.AppConfig.API_ENDPOINT
import net.decodex.dcp.core.constants.AppConfig.API_TIMEOUT
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPassword
import net.decodex.dcp.core.supertokens.recipes.session.Session
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ThirdParty
import net.decodex.dcp.core.supertokens.recipes.thirdparty.provider
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Apple
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Bitbucket
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Facebook
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.GitHub
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.GitLab
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Google
import net.decodex.dcp.core.supertokens.superTokensClient
import net.decodex.dcp.core.utils.InstantSerializer

typealias NoAuthHttpClient = HttpClient
typealias AuthHttpClient = HttpClient

fun createAuthHttpClient(
    superTokensClient: SuperTokensClient,
): AuthHttpClient {
    return superTokensClient.apiClient
}

fun createSuperTokensClient(
    engine: HttpClientEngine,
    preferences: DataStore<Preferences>,
): SuperTokensClient {
    return superTokensClient(ApiRoutes.AUTH, engine, preferences) {
        recipe(EmailPassword)
        recipe(Session)
        recipe(ThirdParty) {
            provider(Google) { redirectUri = "localhost" }
            provider(Facebook) { redirectUri = "localhost" }
            provider(GitHub) { redirectUri = "localhost" }
            provider(GitLab) { redirectUri = "localhost" }
            provider(Bitbucket) { redirectUri = "localhost" }
            provider(Apple) { redirectUri = "localhost" }
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun createHttpClient(
    engine: HttpClientEngine,
    additionalConfig: HttpClientConfig<*>.() -> Unit = {},
): NoAuthHttpClient {
    return HttpClient(engine) {
        install(Logging) {
            level = AppConfig.logLevel
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
                    serializersModule =
                        SerializersModule {
                            contextual(Instant::class, InstantSerializer)
                        }
                },
            )
        }

        defaultRequest {
            header("Content-Type", "application/json")
            url(API_ENDPOINT)
        }

        additionalConfig()
    }
}
