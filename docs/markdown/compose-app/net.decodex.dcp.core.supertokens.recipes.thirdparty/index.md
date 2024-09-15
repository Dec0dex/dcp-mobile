//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [BuildProvider](-build-provider/index.md) | [common]<br>typealias [BuildProvider](-build-provider/index.md) = ([SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), [ThirdPartyRecipe](-third-party-recipe/index.md)) -&gt; [Provider](-provider/index.md)&lt;*&gt; |
| [Provider](-provider/index.md) | [common]<br>abstract class [Provider](-provider/index.md)&lt;out [C](-provider/index.md) : [ProviderConfig](-provider-config/index.md)&gt;(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val config: [C](-provider/index.md)) |
| [ProviderBuilder](-provider-builder/index.md) | [common]<br>abstract class [ProviderBuilder](-provider-builder/index.md)&lt;out [C](-provider-builder/index.md) : [ProviderConfig](-provider-config/index.md), out [R](-provider-builder/index.md) : [Provider](-provider/index.md)&lt;[C](-provider-builder/index.md)&gt;&gt; |
| [ProviderConfig](-provider-config/index.md) | [common]<br>open class [ProviderConfig](-provider-config/index.md) |
| [ThirdParty](-third-party/index.md) | [common]<br>object [ThirdParty](-third-party/index.md) : [RecipeBuilder](../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[ThirdPartyConfig](-third-party-config/index.md), [ThirdPartyRecipe](-third-party-recipe/index.md)&gt; |
| [ThirdPartyConfig](-third-party-config/index.md) | [common]<br>class [ThirdPartyConfig](-third-party-config/index.md) : [RecipeConfig](../net.decodex.dcp.core.supertokens.recipes/-recipe-config/index.md) |
| [ThirdPartyRecipe](-third-party-recipe/index.md) | [common]<br>class [ThirdPartyRecipe](-third-party-recipe/index.md)(superTokens: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [ThirdPartyConfig](-third-party-config/index.md)) : [Recipe](../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[ThirdPartyConfig](-third-party-config/index.md)&gt; |
| [ThirdPartySignIn](-third-party-sign-in/index.md) | [common]<br>abstract class [ThirdPartySignIn](-third-party-sign-in/index.md)&lt;[C](-third-party-sign-in/index.md) : [SignInProviderConfig](../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md)&gt; : [SignInProvider](../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[C](-third-party-sign-in/index.md), [SignInData](../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md)&gt; |
| [ThirdPartySignInAuthCode](-third-party-sign-in-auth-code/index.md) | [common]<br>abstract class [ThirdPartySignInAuthCode](-third-party-sign-in-auth-code/index.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ThirdPartySignIn](-third-party-sign-in/index.md)&lt;[ThirdPartySignInAuthCode.Config](-third-party-sign-in-auth-code/-config/index.md)&gt; |
| [ThirdPartySignInTokens](-third-party-sign-in-tokens/index.md) | [common]<br>abstract class [ThirdPartySignInTokens](-third-party-sign-in-tokens/index.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ThirdPartySignIn](-third-party-sign-in/index.md)&lt;[ThirdPartySignInTokens.Config](-third-party-sign-in-tokens/-config/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getThirdPartyAuthorizationUrl](get-third-party-authorization-url.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[getThirdPartyAuthorizationUrl](get-third-party-authorization-url.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provider](provider.md) | [common]<br>fun &lt;[C](provider.md) : [ProviderConfig](-provider-config/index.md), [R](provider.md) : [Provider](-provider/index.md)&lt;[C](provider.md)&gt;&gt; [ThirdPartyConfig](-third-party-config/index.md).[provider](provider.md)(builder: [ProviderBuilder](-provider-builder/index.md)&lt;[C](provider.md), [R](provider.md)&gt;, configure: [C](provider.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}) |
