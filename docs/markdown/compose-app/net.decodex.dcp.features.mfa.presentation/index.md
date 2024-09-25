//[composeApp](../../index.md)/[net.decodex.dcp.features.mfa.presentation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [MfaEvent](-mfa-event/index.md) | [common]<br>sealed interface [MfaEvent](-mfa-event/index.md) |
| [MfaState](-mfa-state/index.md) | [common]<br>data class [MfaState](-mfa-state/index.md)(val isLoading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val mfaStatus: [MultiFactorAuthStatus](../net.decodex.dcp.core.supertokens.models/-multi-factor-auth-status/index.md)? = null, val isErrorVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |
| [MfaViewModel](-mfa-view-model/index.md) | [common]<br>class [MfaViewModel](-mfa-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [MfaContent](-mfa-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [MfaContent](-mfa-content.md)(state: [MfaState](-mfa-state/index.md), onEvent: ([MfaEvent](-mfa-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [MfaScreen](-mfa-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [MfaScreen](-mfa-screen.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html), state: [MfaState](-mfa-state/index.md), onEvent: ([MfaEvent](-mfa-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
