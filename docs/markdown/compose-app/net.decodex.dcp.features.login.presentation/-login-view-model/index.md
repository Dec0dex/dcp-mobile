//[composeApp](../../../index.md)/[net.decodex.dcp.features.login.presentation](../index.md)/[LoginViewModel](index.md)

# LoginViewModel

[common]\
class [LoginViewModel](index.md)(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [LoginViewModel](-login-view-model.md) | [common]<br>constructor(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [state](state.md) | [common]<br>val [state](state.md): StateFlow&lt;[LoginState](../-login-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#2068605057%2FFunctions%2F-676342820) | [common]<br>expect open fun [addCloseable](index.md#2068605057%2FFunctions%2F-676342820)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html))<br>expect fun [addCloseable](index.md#2093014716%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)) |
| [getCloseable](index.md#1102255800%2FFunctions%2F-676342820) | [common]<br>expect fun &lt;[T](index.md#1102255800%2FFunctions%2F-676342820) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](index.md#1102255800%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#1102255800%2FFunctions%2F-676342820)? |
| [onEvent](on-event.md) | [common]<br>fun [onEvent](on-event.md)(event: [LoginEvent](../-login-event/index.md)) |
