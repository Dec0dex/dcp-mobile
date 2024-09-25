//[composeApp](../../index.md)/[net.decodex.dcp.features.login.presentation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [LoginEvent](-login-event/index.md) | [common]<br>sealed interface [LoginEvent](-login-event/index.md) |
| [LoginState](-login-state/index.md) | [common]<br>data class [LoginState](-login-state/index.md)(val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val emailError: StringResource? = null, val passwordError: StringResource? = null, val isInputValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val apiError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [LoginViewModel](-login-view-model/index.md) | [common]<br>class [LoginViewModel](-login-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), ldClient: LDClient) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [LoginForm](-login-form.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LoginForm](-login-form.md)(state: [LoginState](-login-state/index.md), onEvent: ([LoginEvent](-login-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [LoginScreen](-login-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LoginScreen](-login-screen.md)(state: [LoginState](-login-state/index.md), onEvent: ([LoginEvent](-login-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
