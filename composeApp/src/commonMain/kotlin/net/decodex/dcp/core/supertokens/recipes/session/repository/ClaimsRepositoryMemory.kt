package net.decodex.dcp.core.supertokens.recipes.session.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import net.decodex.dcp.core.supertokens.claims.AccessTokenClaims

class ClaimsRepositoryMemory : ClaimsRepository {
    override val claims: MutableStateFlow<AccessTokenClaims?> = MutableStateFlow(null)

    @OptIn(ExperimentalSerializationApi::class)
    override val decoder: Json =
        Json {
            isLenient = true
            explicitNulls = false
            encodeDefaults = true
            ignoreUnknownKeys = true
        }

    override suspend fun setClaims(claims: String?) {
        this.claims.value = claims?.let { decoder.decodeFromString<AccessTokenClaims>(it) }
    }

    override suspend fun getClaims(): AccessTokenClaims? {
        return claims.value
    }
}
