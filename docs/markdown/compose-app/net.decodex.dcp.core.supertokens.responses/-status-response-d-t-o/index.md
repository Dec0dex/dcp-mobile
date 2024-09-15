//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[StatusResponseDTO](index.md)

# StatusResponseDTO

[common]\
@Serializable

data class [StatusResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [StatusResponseDTO](-status-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [message](message.md) | [common]<br>val [message](message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
