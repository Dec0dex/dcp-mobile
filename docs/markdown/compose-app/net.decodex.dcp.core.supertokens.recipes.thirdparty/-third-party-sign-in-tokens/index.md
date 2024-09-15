//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ThirdPartySignInTokens](index.md)

# ThirdPartySignInTokens

abstract class [ThirdPartySignInTokens](index.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ThirdPartySignIn](../-third-party-sign-in/index.md)&lt;[ThirdPartySignInTokens.Config](-config/index.md)&gt; 

#### Inheritors

| |
|---|
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-apple/-tokens/index.md) |
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-bitbucket/-tokens/index.md) |
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-facebook/-tokens/index.md) |
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-hub/-tokens/index.md) |
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-lab/-tokens/index.md) |
| [Tokens](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-google/-tokens/index.md) |

## Constructors

| | |
|---|---|
| [ThirdPartySignInTokens](-third-party-sign-in-tokens.md) | [common]<br>constructor(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | [common]<br>data class [Config](-config/index.md)(var accessToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var idToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SignInProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [common]<br>open suspend override fun [signIn](sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [ThirdPartySignInTokens.Config](-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
