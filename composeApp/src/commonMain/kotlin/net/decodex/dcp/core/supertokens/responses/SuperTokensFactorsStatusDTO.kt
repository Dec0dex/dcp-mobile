package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class FactorsStatusDTO(
    val alreadySetup: List<String> = emptyList(),
    val allowedToSetup: List<String> = emptyList(),
    val next: List<String> = emptyList(),
)

@Serializable
data class EmailsStatusDTO(
    @SerialName("emailpassword") val emailPassword: List<String> = emptyList(),
    @SerialName("otp-email") val otp: List<String> = emptyList(),
    @SerialName("link-email") val link: List<String> = emptyList(),
)

@Serializable
data class PhoneStatusDTO(
    @SerialName("otp-phone") val otp: List<String> = emptyList(),
    @SerialName("link-phone") val link: List<String> = emptyList(),
)

@Serializable
data class MultiFactorStatusResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val factors: FactorsStatusDTO? = null,
    val emails: EmailsStatusDTO? = null,
    val phoneNumbers: PhoneStatusDTO? = null,
) : SuperTokensBaseResponseDTO
