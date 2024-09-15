package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.models.SuperTokensUser

@Serializable
data class FormFieldErrorDTO(
    val id: String,
    val error: String,
)

@Serializable
data class SignInResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val user: SuperTokensUser? = null,
    val formFields: List<FormFieldErrorDTO>? = null,
    val message: String? = null,
) : SuperTokensBaseResponseDTO
