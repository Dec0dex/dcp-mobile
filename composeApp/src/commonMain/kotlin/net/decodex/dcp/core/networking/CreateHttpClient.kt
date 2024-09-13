package net.decodex.dcp.core.networking

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import net.decodex.dcp.core.constants.AppConfig
import net.decodex.dcp.core.constants.AppConfig.API_ENDPOINT
import net.decodex.dcp.core.constants.AppConfig.API_TIMEOUT
import net.decodex.dcp.core.constants.PreferenceKey
import net.decodex.dcp.core.utils.InstantSerializer

typealias NoAuthHttpClient = HttpClient
typealias AuthHttpClient = HttpClient

fun createAuthHttpClient(
    engine: HttpClientEngine,
    preferences: DataStore<Preferences>,
): AuthHttpClient {
    return createHttpClient(engine) {
        install(Auth) {
            bearer {
                loadTokens {
                    getBearerTokens(preferences)
                }
                refreshTokens {
                    refreshTokens(preferences)
                }
            }
        }
    }
}

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
                json =
                    Json {
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

private suspend fun getBearerTokens(preferences: DataStore<Preferences>): BearerTokens {
    return preferences.data.map {
        val accessToken = it[PreferenceKey.accessToken].orEmpty()
        val refreshToken = it[PreferenceKey.refreshToken].orEmpty()
        BearerTokens(accessToken, refreshToken)
    }.last()
}

private suspend fun refreshTokens(preferences: DataStore<Preferences>): BearerTokens {
    var accessToken = ""
    var refreshToken = ""
    // TODO: Implement refresh
    return saveTokens(preferences, accessToken, refreshToken)
}

private suspend fun saveTokens(
    preferences: DataStore<Preferences>,
    accessToken: String,
    refreshToken: String,
): BearerTokens {
    preferences.edit {
        it[PreferenceKey.accessToken] = accessToken
        it[PreferenceKey.refreshToken] = refreshToken
    }
    return BearerTokens(accessToken, refreshToken)
}
