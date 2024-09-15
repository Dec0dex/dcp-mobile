package net.decodex.dcp.core.supertokens.requests

import kotlinx.serialization.Serializable

@Serializable
data class VerifyTotpRequestDTO(
    val totp: String,
)
