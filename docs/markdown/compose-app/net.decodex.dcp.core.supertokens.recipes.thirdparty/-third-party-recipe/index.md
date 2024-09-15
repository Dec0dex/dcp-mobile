//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ThirdPartyRecipe](index.md)

# ThirdPartyRecipe

[common]\
class [ThirdPartyRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [ThirdPartyConfig](../-third-party-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[ThirdPartyConfig](../-third-party-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [ThirdPartyRecipe](-third-party-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [ThirdPartyConfig](../-third-party-config/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [pkceRepository](pkce-repository.md) | [common]<br>val [pkceRepository](pkce-repository.md): [PkceRepository](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.repositories/-pkce-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [getAuthUrl](get-auth-url.md) | [common]<br>suspend fun [getAuthUrl](get-auth-url.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getProviderById](get-provider-by-id.md) | [common]<br>fun [getProviderById](get-provider-by-id.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Provider](../-provider/index.md)&lt;*&gt; |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
| [thirdPartyAuthCodeSignIn](third-party-auth-code-sign-in.md) | [common]<br>suspend fun [thirdPartyAuthCodeSignIn](third-party-auth-code-sign-in.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), redirectURI: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), redirectURIQueryParams: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
| [thirdPartyTokenSignIn](third-party-token-sign-in.md) | [common]<br>suspend fun [thirdPartyTokenSignIn](third-party-token-sign-in.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), accessToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), idToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
