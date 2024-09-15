package net.decodex.dcp.core.supertokens.requests

import kotlinx.serialization.Serializable

@Serializable
data class VerifyEmailTokenRequestDTO(
    val method: String = "token",
    val token: String,
)
