//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ThirdPartySignInAuthCode](index.md)

# ThirdPartySignInAuthCode

abstract class [ThirdPartySignInAuthCode](index.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ThirdPartySignIn](../-third-party-sign-in/index.md)&lt;[ThirdPartySignInAuthCode.Config](-config/index.md)&gt; 

#### Inheritors

| |
|---|
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-apple/-auth-code/index.md) |
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-bitbucket/-auth-code/index.md) |
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-facebook/-auth-code/index.md) |
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-hub/-auth-code/index.md) |
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-lab/-auth-code/index.md) |
| [AuthCode](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-google/-auth-code/index.md) |

## Constructors

| | |
|---|---|
| [ThirdPartySignInAuthCode](-third-party-sign-in-auth-code.md) | [common]<br>constructor(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | [common]<br>data class [Config](-config/index.md)(var redirectURIQueryParams: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, var clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SignInProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [common]<br>open suspend override fun [signIn](sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [ThirdPartySignInAuthCode.Config](-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
