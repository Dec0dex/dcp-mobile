//[composeApp](../../../index.md)/[net.decodex.dcp.features.totp.presentation](../index.md)/[TotpViewModel](index.md)

# TotpViewModel

[common]\
class [TotpViewModel](index.md)(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [TotpViewModel](-totp-view-model.md) | [common]<br>constructor(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [navigator](navigator.md) | [common]<br>lateinit var [navigator](navigator.md): [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html) |
| [state](state.md) | [common]<br>val [state](state.md): StateFlow&lt;[TotpState](../-totp-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#2068605057%2FFunctions%2F-676342820) | [common]<br>expect open fun [addCloseable](index.md#2068605057%2FFunctions%2F-676342820)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html))<br>expect fun [addCloseable](index.md#2093014716%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)) |
| [getCloseable](index.md#1102255800%2FFunctions%2F-676342820) | [common]<br>expect fun &lt;[T](index.md#1102255800%2FFunctions%2F-676342820) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](index.md#1102255800%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#1102255800%2FFunctions%2F-676342820)? |
| [onEvent](on-event.md) | [common]<br>fun [onEvent](on-event.md)(event: [TotpEvent](../-totp-event/index.md)) |
