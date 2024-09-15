package net.decodex.dcp.core.supertokens.recipes.session.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import net.decodex.dcp.core.supertokens.claims.AccessTokenClaims

@OptIn(ExperimentalSerializationApi::class)
class ClaimsRepositorySettings(
    private val settings: DataStore<Preferences>,
    override val decoder: Json =
        Json {
            isLenient = true
            explicitNulls = false
            encodeDefaults = true
            ignoreUnknownKeys = true
        },
    scope: CoroutineScope,
) : ClaimsRepository {
    override val claims: MutableStateFlow<AccessTokenClaims?> = MutableStateFlow(null)

    init {
        scope.launch {
            getClaims()?.let { claims.value = it }
        }
    }

    private fun updateClaims(claims: String?) {
        this.claims.value = claims?.let { decoder.decodeFromString<AccessTokenClaims>(it) }
    }

    override suspend fun setClaims(claims: String?) {
        claims?.let {
            settings.edit {
                it[KEY_USER_CLAIMS] = claims
            }
        }
        updateClaims(claims)
    }

    override suspend fun getClaims(): AccessTokenClaims? {
        return settings.data.map {
            val value = it[KEY_USER_CLAIMS].orEmpty()
            decoder.decodeFromString<AccessTokenClaims>(value)
        }.last()
    }

    companion object {
        private val KEY_USER_CLAIMS = stringPreferencesKey("userClaims")
    }
}
