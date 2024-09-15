//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.handlers](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [FormFieldException](-form-field-exception/index.md) | [common]<br>class [FormFieldException](-form-field-exception/index.md)(val errors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[FormFieldErrorDTO](../net.decodex.dcp.core.supertokens.responses/-form-field-error-d-t-o/index.md)&gt;) : [SuperTokensStatusException](../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/index.md) |
| [SignInProvider](-sign-in-provider/index.md) | [common]<br>interface [SignInProvider](-sign-in-provider/index.md)&lt;[C](-sign-in-provider/index.md) : [SignInProviderConfig](-sign-in-provider-config/index.md), [R](-sign-in-provider/index.md)&gt; |
| [SignInProviderConfig](-sign-in-provider-config/index.md) | [common]<br>interface [SignInProviderConfig](-sign-in-provider-config/index.md) |
| [SignUpProvider](-sign-up-provider/index.md) | [common]<br>interface [SignUpProvider](-sign-up-provider/index.md)&lt;[C](-sign-up-provider/index.md) : [SignUpProviderConfig](-sign-up-provider-config/index.md), [R](-sign-up-provider/index.md)&gt; |
| [SignUpProviderConfig](-sign-up-provider-config/index.md) | [common]<br>interface [SignUpProviderConfig](-sign-up-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signInWith](sign-in-with.md) | [common]<br>suspend fun &lt;[C](sign-in-with.md), [Provider](sign-in-with.md) : [SignInProvider](-sign-in-provider/index.md)&lt;[C](sign-in-with.md), [R](sign-in-with.md)&gt;, [R](sign-in-with.md)&gt; [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[signInWith](sign-in-with.md)(provider: [Provider](sign-in-with.md), config: [C](sign-in-with.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](sign-in-with.md) |
| [signUpWith](sign-up-with.md) | [common]<br>suspend fun &lt;[C](sign-up-with.md), [Provider](sign-up-with.md) : [SignUpProvider](-sign-up-provider/index.md)&lt;[C](sign-up-with.md), [R](sign-up-with.md)&gt;, [R](sign-up-with.md)&gt; [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[signUpWith](sign-up-with.md)(provider: [Provider](sign-up-with.md), config: [C](sign-up-with.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](sign-up-with.md) |
