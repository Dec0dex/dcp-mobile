//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.recipes.emailverification](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [EmailVerification](-email-verification/index.md) | [common]<br>object [EmailVerification](-email-verification/index.md) : [RecipeBuilder](../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[EmailVerificationConfig](-email-verification-config/index.md), [EmailVerificationRecipe](-email-verification-recipe/index.md)&gt; |
| [EmailVerificationConfig](-email-verification-config/index.md) | [common]<br>class [EmailVerificationConfig](-email-verification-config/index.md) : [RecipeConfig](../net.decodex.dcp.core.supertokens.recipes/-recipe-config/index.md) |
| [EmailVerificationRecipe](-email-verification-recipe/index.md) | [common]<br>class [EmailVerificationRecipe](-email-verification-recipe/index.md)(superTokens: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [EmailVerificationConfig](-email-verification-config/index.md)) : [Recipe](../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[EmailVerificationConfig](-email-verification-config/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [checkEmailVerified](check-email-verified.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[checkEmailVerified](check-email-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sendVerificationEmail](send-verification-email.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[sendVerificationEmail](send-verification-email.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [verifyEmail](verify-email.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[verifyEmail](verify-email.md)(token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
