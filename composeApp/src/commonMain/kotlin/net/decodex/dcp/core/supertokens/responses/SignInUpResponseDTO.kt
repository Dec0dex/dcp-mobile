package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.models.SuperTokensUser

@Serializable
data class SignInUpResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val createdNewUser: Boolean?,
    val user: SuperTokensUser?,
) : SuperTokensBaseResponseDTO
