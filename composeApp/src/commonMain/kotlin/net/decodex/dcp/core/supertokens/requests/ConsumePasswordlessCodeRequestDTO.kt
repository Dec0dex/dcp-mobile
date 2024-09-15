package net.decodex.dcp.core.supertokens.requests

import kotlinx.serialization.Serializable

@Serializable
data class ConsumePasswordlessCodeRequestDTO(
    val preAuthSessionId: String,
    val linkCode: String? = null,
    val deviceId: String? = null,
    val userInputCode: String? = null,
)
