package net.decodex.dcp.core.supertokens.models

data class SignInData(
    val createdNewUser: Boolean,
    val user: SuperTokensUser,
)
