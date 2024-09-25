//[composeApp](../../../index.md)/[net.decodex.dcp.features.emailotp.presnetation](../index.md)/[OtpState](index.md)

# OtpState

[common]\
data class [OtpState](index.md)(val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val otpSent: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val inputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val signUpData: [PasswordlessSignUpData](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-sign-up-data/index.md)? = null, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val authFactor: [AuthFactor](../../net.decodex.dcp.core.supertokens.models/-auth-factor/index.md) = AuthFactor.OtpEmail, val claims: [AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? = null)

## Constructors

| | |
|---|---|
| [OtpState](-otp-state.md) | [common]<br>constructor(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, otpSent: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, inputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, signUpData: [PasswordlessSignUpData](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-sign-up-data/index.md)? = null, isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, authFactor: [AuthFactor](../../net.decodex.dcp.core.supertokens.models/-auth-factor/index.md) = AuthFactor.OtpEmail, claims: [AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [authFactor](auth-factor.md) | [common]<br>val [authFactor](auth-factor.md): [AuthFactor](../../net.decodex.dcp.core.supertokens.models/-auth-factor/index.md) |
| [claims](claims.md) | [common]<br>val [claims](claims.md): [AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? = null |
| [email](email.md) | [common]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [errorMessage](error-message.md) | [common]<br>val [errorMessage](error-message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [inputCode](input-code.md) | [common]<br>val [inputCode](input-code.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [isErrorVisible](is-error-visible.md) | [common]<br>val [isErrorVisible](is-error-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isLoading](is-loading.md) | [common]<br>val [isLoading](is-loading.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [otpSent](otp-sent.md) | [common]<br>val [otpSent](otp-sent.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [phoneNumber](phone-number.md) | [common]<br>val [phoneNumber](phone-number.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [signUpData](sign-up-data.md) | [common]<br>val [signUpData](sign-up-data.md): [PasswordlessSignUpData](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-sign-up-data/index.md)? = null |
