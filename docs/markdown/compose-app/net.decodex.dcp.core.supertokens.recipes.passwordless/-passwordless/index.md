//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.passwordless](../index.md)/[Passwordless](index.md)

# Passwordless

[common]\
object [Passwordless](index.md) : [RecipeBuilder](../../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[PasswordlessConfig](../-passwordless-config/index.md), [PasswordlessRecipe](../-passwordless-recipe/index.md)&gt; , [SignUpProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider/index.md)&lt;[Passwordless.SignUpConfig](-sign-up-config/index.md), [PasswordlessSignUpData](../-passwordless-sign-up-data/index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [SignUpConfig](-sign-up-config/index.md) | [common]<br>data class [SignUpConfig](-sign-up-config/index.md)(var email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SignUpProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [install](install.md) | [common]<br>open override fun [install](install.md)(configure: [PasswordlessConfig](../-passwordless-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): ([SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) -&gt; [PasswordlessRecipe](../-passwordless-recipe/index.md) |
| [signUp](sign-up.md) | [common]<br>open suspend override fun [signUp](sign-up.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [Passwordless.SignUpConfig](-sign-up-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [PasswordlessSignUpData](../-passwordless-sign-up-data/index.md) |
