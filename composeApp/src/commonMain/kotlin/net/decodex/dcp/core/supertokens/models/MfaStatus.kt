package net.decodex.dcp.core.supertokens.models

data class FactorsStatus(
    val alreadySetup: List<String> = emptyList(),
    val allowedToSetup: List<String> = emptyList(),
    val next: List<String> = emptyList(),
)

data class EmailsStatus(
    val emailPassword: List<String> = emptyList(),
    val otp: List<String> = emptyList(),
    val link: List<String> = emptyList(),
)

data class PhoneStatus(
    val otp: List<String> = emptyList(),
    val link: List<String> = emptyList(),
)

data class MultiFactorAuthStatus(
    val factors: FactorsStatus,
    val emails: EmailsStatus,
    val phoneNumbers: PhoneStatus,
)
