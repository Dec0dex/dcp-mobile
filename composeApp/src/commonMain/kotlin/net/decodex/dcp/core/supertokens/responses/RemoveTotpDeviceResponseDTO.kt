package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class RemoveTotpDeviceResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val didDeviceExist: Boolean? = null,
) : SuperTokensBaseResponseDTO
