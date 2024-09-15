package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class StatusResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val message: String? = null,
) : SuperTokensBaseResponseDTO
