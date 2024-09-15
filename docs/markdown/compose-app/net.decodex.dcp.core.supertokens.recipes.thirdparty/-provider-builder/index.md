//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ProviderBuilder](index.md)

# ProviderBuilder

abstract class [ProviderBuilder](index.md)&lt;out [C](index.md) : [ProviderConfig](../-provider-config/index.md), out [R](index.md) : [Provider](../-provider/index.md)&lt;[C](index.md)&gt;&gt;

#### Inheritors

| |
|---|
| [Apple](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-apple/index.md) |
| [Bitbucket](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-bitbucket/index.md) |
| [Facebook](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-facebook/index.md) |
| [GitHub](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-hub/index.md) |
| [GitLab](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-git-lab/index.md) |
| [Google](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.providers/-google/index.md) |

## Constructors

| | |
|---|---|
| [ProviderBuilder](-provider-builder.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [install](install.md) | [common]<br>abstract fun [install](install.md)(configure: [C](index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): ([SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), [ThirdPartyRecipe](../-third-party-recipe/index.md)) -&gt; [R](index.md) |
