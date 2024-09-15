//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes](../index.md)/[RecipeBuilder](index.md)

# RecipeBuilder

abstract class [RecipeBuilder](index.md)&lt;[C](index.md) : [RecipeConfig](../-recipe-config/index.md), [R](index.md) : [Recipe](../-recipe/index.md)&lt;[C](index.md)&gt;&gt;

#### Inheritors

| |
|---|
| [EmailPassword](../../net.decodex.dcp.core.supertokens.recipes.emailpassword/-email-password/index.md) |
| [EmailVerification](../../net.decodex.dcp.core.supertokens.recipes.emailverification/-email-verification/index.md) |
| [MultiFactorAuth](../../net.decodex.dcp.core.supertokens.recipes.multifactor/-multi-factor-auth/index.md) |
| [Passwordless](../../net.decodex.dcp.core.supertokens.recipes.passwordless/-passwordless/index.md) |
| [Session](../../net.decodex.dcp.core.supertokens.recipes.session/-session/index.md) |
| [ThirdParty](../../net.decodex.dcp.core.supertokens.recipes.thirdparty/-third-party/index.md) |
| [Totp](../../net.decodex.dcp.core.supertokens.recipes.totp/-totp/index.md) |

## Constructors

| | |
|---|---|
| [RecipeBuilder](-recipe-builder.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [install](install.md) | [common]<br>abstract fun [install](install.md)(configure: [C](index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [BuildRecipe](../-build-recipe/index.md) |
