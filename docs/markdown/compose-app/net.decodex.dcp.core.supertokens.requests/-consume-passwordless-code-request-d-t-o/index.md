//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.requests](../index.md)/[ConsumePasswordlessCodeRequestDTO](index.md)

# ConsumePasswordlessCodeRequestDTO

[common]\
@Serializable

data class [ConsumePasswordlessCodeRequestDTO](index.md)(val preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val linkCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val userInputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

## Constructors

| | |
|---|---|
| [ConsumePasswordlessCodeRequestDTO](-consume-passwordless-code-request-d-t-o.md) | [common]<br>constructor(preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), linkCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, userInputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [deviceId](device-id.md) | [common]<br>val [deviceId](device-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [linkCode](link-code.md) | [common]<br>val [linkCode](link-code.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [preAuthSessionId](pre-auth-session-id.md) | [common]<br>val [preAuthSessionId](pre-auth-session-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [userInputCode](user-input-code.md) | [common]<br>val [userInputCode](user-input-code.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
