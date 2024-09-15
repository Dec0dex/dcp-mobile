//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty](../index.md)/[ThirdPartyConfig](index.md)

# ThirdPartyConfig

[common]\
class [ThirdPartyConfig](index.md) : [RecipeConfig](../../net.decodex.dcp.core.supertokens.recipes/-recipe-config/index.md)

## Constructors

| | |
|---|---|
| [ThirdPartyConfig](-third-party-config.md) | [common]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [pkceRepository](pkce-repository.md) | [common]<br>var [pkceRepository](pkce-repository.md): [PkceRepository](../../net.decodex.dcp.core.supertokens.recipes.thirdparty.repositories/-pkce-repository/index.md)? |
| [providers](providers.md) | [common]<br>var [providers](providers.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[BuildProvider](../-build-provider/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [provider](../provider.md) | [common]<br>fun &lt;[C](../provider.md) : [ProviderConfig](../-provider-config/index.md), [R](../provider.md) : [Provider](../-provider/index.md)&lt;[C](../provider.md)&gt;&gt; [ThirdPartyConfig](index.md).[provider](../provider.md)(builder: [ProviderBuilder](../-provider-builder/index.md)&lt;[C](../provider.md), [R](../provider.md)&gt;, configure: [C](../provider.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}) |
| [unaryPlus](unary-plus.md) | [common]<br>operator fun [BuildProvider](../-build-provider/index.md).[unaryPlus](unary-plus.md)() |
