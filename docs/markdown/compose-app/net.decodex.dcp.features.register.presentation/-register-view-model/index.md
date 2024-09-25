//[composeApp](../../../index.md)/[net.decodex.dcp.features.register.presentation](../index.md)/[RegisterViewModel](index.md)

# RegisterViewModel

[common]\
class [RegisterViewModel](index.md)(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [RegisterViewModel](-register-view-model.md) | [common]<br>constructor(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [navigator](navigator.md) | [common]<br>lateinit var [navigator](navigator.md): [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html) |
| [state](state.md) | [common]<br>val [state](state.md): StateFlow&lt;[RegisterState](../-register-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2068605057%2FFunctions%2F-676342820) | [common]<br>expect open fun [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2068605057%2FFunctions%2F-676342820)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html))<br>expect fun [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2093014716%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)) |
| [getCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820) | [common]<br>expect fun &lt;[T](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820)? |
| [onEvent](on-event.md) | [common]<br>fun [onEvent](on-event.md)(event: [RegisterEvent](../-register-event/index.md)) |
