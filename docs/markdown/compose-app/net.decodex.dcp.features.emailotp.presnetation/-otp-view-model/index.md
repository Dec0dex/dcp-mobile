//[composeApp](../../../index.md)/[net.decodex.dcp.features.emailotp.presnetation](../index.md)/[OtpViewModel](index.md)

# OtpViewModel

[common]\
class [OtpViewModel](index.md)(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), ldClient: LDClient) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [OtpViewModel](-otp-view-model.md) | [common]<br>constructor(client: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), ldClient: LDClient) |

## Properties

| Name | Summary |
|---|---|
| [state](state.md) | [common]<br>val [state](state.md): StateFlow&lt;[OtpState](../-otp-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2068605057%2FFunctions%2F-676342820) | [common]<br>expect open fun [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2068605057%2FFunctions%2F-676342820)(closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html))<br>expect fun [addCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#2093014716%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)) |
| [getCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820) | [common]<br>expect fun &lt;[T](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820) : [AutoCloseable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../../net.decodex.dcp.features.totp.presentation/-totp-view-model/index.md#1102255800%2FFunctions%2F-676342820)? |
| [init](init.md) | [common]<br>fun [init](init.md)(authFactor: [AuthFactor](../../net.decodex.dcp.core.supertokens.models/-auth-factor/index.md), navigator: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html)) |
| [onEvent](on-event.md) | [common]<br>fun [onEvent](on-event.md)(event: [OtpEvent](../-otp-event/index.md)) |
