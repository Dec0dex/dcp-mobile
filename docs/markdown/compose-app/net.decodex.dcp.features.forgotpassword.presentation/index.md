//[composeApp](../../index.md)/[net.decodex.dcp.features.forgotpassword.presentation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ForgotPasswordEvent](-forgot-password-event/index.md) | [common]<br>sealed interface [ForgotPasswordEvent](-forgot-password-event/index.md) |
| [ForgotPasswordState](-forgot-password-state/index.md) | [common]<br>data class [ForgotPasswordState](-forgot-password-state/index.md)(val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val emailError: StringResource? = null, val isInputValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val emailSent: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |
| [ForgotPasswordViewModel](-forgot-password-view-model/index.md) | [common]<br>class [ForgotPasswordViewModel](-forgot-password-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [ForgotPasswordContent](-forgot-password-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ForgotPasswordContent](-forgot-password-content.md)(state: [ForgotPasswordState](-forgot-password-state/index.md), onEvent: ([ForgotPasswordEvent](-forgot-password-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [ForgotPasswordScreen](-forgot-password-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [ForgotPasswordScreen](-forgot-password-screen.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html), state: [ForgotPasswordState](-forgot-password-state/index.md), onEvent: ([ForgotPasswordEvent](-forgot-password-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
