package net.decodex.dcp.features.emailotp.presnetation

import net.decodex.dcp.core.supertokens.claims.AccessTokenClaims
import net.decodex.dcp.core.supertokens.models.AuthFactor
import net.decodex.dcp.core.supertokens.recipes.passwordless.PasswordlessSignUpData

data class OtpState(
    val email: String? = null,
    val phoneNumber: String? = null,
    val otpSent: Boolean = false,
    val inputCode: String? = null,
    val isLoading: Boolean = false,
    val signUpData: PasswordlessSignUpData? = null,
    val isErrorVisible: Boolean = false,
    val errorMessage: String? = null,
    val authFactor: AuthFactor = AuthFactor.OtpEmail,
    val claims: AccessTokenClaims? = null,
)
