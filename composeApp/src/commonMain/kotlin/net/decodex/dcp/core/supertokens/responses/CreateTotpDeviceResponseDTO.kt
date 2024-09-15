package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class CreateTotpDeviceResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val deviceName: String? = null,
    val qrCodeString: String? = null,
    val secret: String? = null,
) : SuperTokensBaseResponseDTO
