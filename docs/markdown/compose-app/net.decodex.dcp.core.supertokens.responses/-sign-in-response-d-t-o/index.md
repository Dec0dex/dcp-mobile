//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[SignInResponseDTO](index.md)

# SignInResponseDTO

[common]\
@Serializable

data class [SignInResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? = null, val formFields: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[FormFieldErrorDTO](../-form-field-error-d-t-o/index.md)&gt;? = null, val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [SignInResponseDTO](-sign-in-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? = null, formFields: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[FormFieldErrorDTO](../-form-field-error-d-t-o/index.md)&gt;? = null, message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [formFields](form-fields.md) | [common]<br>val [formFields](form-fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[FormFieldErrorDTO](../-form-field-error-d-t-o/index.md)&gt;? = null |
| [message](message.md) | [common]<br>val [message](message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [user](user.md) | [common]<br>val [user](user.md): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? = null |
