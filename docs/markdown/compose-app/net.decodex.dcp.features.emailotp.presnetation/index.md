//[composeApp](../../index.md)/[net.decodex.dcp.features.emailotp.presnetation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [OtpEvent](-otp-event/index.md) | [common]<br>sealed interface [OtpEvent](-otp-event/index.md) |
| [OtpState](-otp-state/index.md) | [common]<br>data class [OtpState](-otp-state/index.md)(val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val otpSent: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val inputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val signUpData: [PasswordlessSignUpData](../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-sign-up-data/index.md)? = null, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val authFactor: [AuthFactor](../net.decodex.dcp.core.supertokens.models/-auth-factor/index.md) = AuthFactor.OtpEmail, val claims: [AccessTokenClaims](../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? = null) |
| [OtpViewModel](-otp-view-model/index.md) | [common]<br>class [OtpViewModel](-otp-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), ldClient: LDClient) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [OtpContent](-otp-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [OtpContent](-otp-content.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), state: [OtpState](-otp-state/index.md), onEvent: ([OtpEvent](-otp-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [OtpScreen](-otp-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [OtpScreen](-otp-screen.md)(navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html), state: [OtpState](-otp-state/index.md), onEvent: ([OtpEvent](-otp-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
