//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[SignInUpResponseDTO](index.md)

# SignInUpResponseDTO

[common]\
@Serializable

data class [SignInUpResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val createdNewUser: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, val user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [SignInUpResponseDTO](-sign-in-up-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, createdNewUser: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [createdNewUser](created-new-user.md) | [common]<br>val [createdNewUser](created-new-user.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [user](user.md) | [common]<br>val [user](user.md): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? |
