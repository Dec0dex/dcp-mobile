//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.passwordless](../index.md)/[PasswordlessLinkCode](index.md)

# PasswordlessLinkCode

[common]\
object [PasswordlessLinkCode](index.md) : [SignInProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[PasswordlessLinkCode.SignInConfig](-sign-in-config/index.md), [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [SignInConfig](-sign-in-config/index.md) | [common]<br>data class [SignInConfig](-sign-in-config/index.md)(var preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var linkCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SignInProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [common]<br>open suspend override fun [signIn](sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [PasswordlessLinkCode.SignInConfig](-sign-in-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
