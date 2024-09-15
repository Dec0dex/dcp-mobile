package net.decodex.dcp.core.supertokens.requests

import kotlinx.serialization.Serializable

@Serializable
data class PasswordResetRequestDTO(
    val method: String = "token",
    val token: String?,
    val formFields: List<FormFieldDTO>,
)
