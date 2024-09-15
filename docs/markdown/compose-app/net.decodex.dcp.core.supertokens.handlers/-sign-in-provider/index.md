//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.handlers](../index.md)/[SignInProvider](index.md)

# SignInProvider

interface [SignInProvider](index.md)&lt;[C](index.md) : [SignInProviderConfig](../-sign-in-provider-config/index.md), [R](index.md)&gt;

#### Inheritors

| |
|---|
| [EmailPassword](../../net.decodex.dcp.core.supertokens.recipes.emailpassword/-email-password/index.md) |
| [PasswordlessLinkCode](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-link-code/index.md) |
| [PasswordlessInputCode](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless-input-code/index.md) |
| [ThirdPartySignIn](../../net.decodex.dcp.core.supertokens.recipes.thirdparty/-third-party-sign-in/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [common]<br>abstract suspend fun [signIn](sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [C](index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](index.md) |
