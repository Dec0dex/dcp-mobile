//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ThirdPartySignIn](index.md)

# ThirdPartySignIn

abstract class [ThirdPartySignIn](index.md)&lt;[C](index.md) : [SignInProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md)&gt; : [SignInProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[C](index.md), [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md)&gt; 

#### Inheritors

| |
|---|
| [ThirdPartySignInAuthCode](../-third-party-sign-in-auth-code/index.md) |
| [ThirdPartySignInTokens](../-third-party-sign-in-tokens/index.md) |

## Constructors

| | |
|---|---|
| [ThirdPartySignIn](-third-party-sign-in.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [signIn](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/sign-in.md) | [common]<br>abstract suspend fun [signIn](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [C](index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
