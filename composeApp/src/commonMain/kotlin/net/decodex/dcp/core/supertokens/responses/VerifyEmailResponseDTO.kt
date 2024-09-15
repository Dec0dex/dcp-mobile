package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class VerifyEmailResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val isVerified: Boolean?,
) : SuperTokensBaseResponseDTO
