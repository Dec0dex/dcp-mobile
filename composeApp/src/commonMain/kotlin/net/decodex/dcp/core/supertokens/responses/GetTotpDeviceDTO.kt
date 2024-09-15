package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class TotpDeviceDTO(
    val name: String,
    val period: Long,
    val skew: Long,
    val verified: Boolean,
)

@Serializable
data class GetTotpDevicesResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val devices: List<TotpDeviceDTO>? = null,
) : SuperTokensBaseResponseDTO
