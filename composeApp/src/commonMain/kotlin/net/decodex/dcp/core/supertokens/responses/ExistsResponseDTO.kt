package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class ExistsResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val exists: Boolean,
) : SuperTokensBaseResponseDTO
