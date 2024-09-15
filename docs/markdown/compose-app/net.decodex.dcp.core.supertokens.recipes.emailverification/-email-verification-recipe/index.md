//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.emailverification](../index.md)/[EmailVerificationRecipe](index.md)

# EmailVerificationRecipe

[common]\
class [EmailVerificationRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [EmailVerificationConfig](../-email-verification-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[EmailVerificationConfig](../-email-verification-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [EmailVerificationRecipe](-email-verification-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [EmailVerificationConfig](../-email-verification-config/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [checkEmailVerified](check-email-verified.md) | [common]<br>suspend fun [checkEmailVerified](check-email-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
| [sendVerificationEmail](send-verification-email.md) | [common]<br>suspend fun [sendVerificationEmail](send-verification-email.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [verifyEmail](verify-email.md) | [common]<br>suspend fun [verifyEmail](verify-email.md)(token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
