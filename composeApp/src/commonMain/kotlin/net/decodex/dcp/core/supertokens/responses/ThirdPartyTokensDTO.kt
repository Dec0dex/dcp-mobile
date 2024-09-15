package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThirdPartyTokensDTO(
    @SerialName("access_token") val accessToken: String,
    @SerialName("id_token") val idToken: String? = null,
)
