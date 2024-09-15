package net.decodex.dcp.core.supertokens.requests

import kotlinx.serialization.Serializable

@Serializable
data class VerifyTotpDeviceRequestDTO(
    val deviceName: String,
    val totp: String,
)
