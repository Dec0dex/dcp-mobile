//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[StartPasswordlessSignInUpResponseDTO](index.md)

# StartPasswordlessSignInUpResponseDTO

[common]\
@Serializable

data class [StartPasswordlessSignInUpResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val flowType: [PasswordlessMode](../../net.decodex.dcp.core.supertokens.models/-passwordless-mode/index.md)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [StartPasswordlessSignInUpResponseDTO](-start-passwordless-sign-in-up-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, flowType: [PasswordlessMode](../../net.decodex.dcp.core.supertokens.models/-passwordless-mode/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [deviceId](device-id.md) | [common]<br>val [deviceId](device-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [flowType](flow-type.md) | [common]<br>val [flowType](flow-type.md): [PasswordlessMode](../../net.decodex.dcp.core.supertokens.models/-passwordless-mode/index.md)? = null |
| [preAuthSessionId](pre-auth-session-id.md) | [common]<br>val [preAuthSessionId](pre-auth-session-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
