//[composeApp](../../index.md)/[net.decodex.dcp.features.totp.presentation](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [TotpEvent](-totp-event/index.md) | [common]<br>sealed interface [TotpEvent](-totp-event/index.md) |
| [TotpState](-totp-state/index.md) | [common]<br>sealed interface [TotpState](-totp-state/index.md) |
| [TotpViewModel](-totp-view-model/index.md) | [common]<br>class [TotpViewModel](-totp-view-model/index.md)(client: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [TotpScreen](-totp-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [TotpScreen](-totp-screen.md)(state: [TotpState](-totp-state/index.md), onEvent: ([TotpEvent](-totp-event/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
