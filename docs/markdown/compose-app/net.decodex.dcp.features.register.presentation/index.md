//[composeApp](../../index.md)/[net.decodex.dcp.features.register.presentation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [RegisterEvent](-register-event/index.md) | [common]<br>sealed interface [RegisterEvent](-register-event/index.md) |
| [RegisterState](-register-state/index.md) | [common]<br>data class [RegisterState](-register-state/index.md)(val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val emailError: StringResource? = null, val passwordError: StringResource? = null, val isInputValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [RegisterViewModel](-register-view-model/index.md) | [common]<br>class [RegisterViewModel](-register-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [RegisterForm](-register-form.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [RegisterForm](-register-form.md)(state: [RegisterState](-register-state/index.md), onEvent: ([RegisterEvent](-register-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [RegisterScreen](-register-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [RegisterScreen](-register-screen.md)(navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html), state: [RegisterState](-register-state/index.md), onEvent: ([RegisterEvent](-register-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
