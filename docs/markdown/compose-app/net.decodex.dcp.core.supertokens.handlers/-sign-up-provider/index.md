//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.handlers](../index.md)/[SignUpProvider](index.md)

# SignUpProvider

interface [SignUpProvider](index.md)&lt;[C](index.md) : [SignUpProviderConfig](../-sign-up-provider-config/index.md), [R](index.md)&gt;

#### Inheritors

| |
|---|
| [EmailPassword](../../net.decodex.dcp.core.supertokens.recipes.emailpassword/-email-password/index.md) |
| [Passwordless](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signUp](sign-up.md) | [common]<br>abstract suspend fun [signUp](sign-up.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [C](index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](index.md) |
