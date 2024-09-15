//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.emailpassword](../index.md)/[EmailPasswordRecipe](index.md)

# EmailPasswordRecipe

[common]\
class [EmailPasswordRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [EmailPasswordConfig](../-email-password-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[EmailPasswordConfig](../-email-password-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [EmailPasswordRecipe](-email-password-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [EmailPasswordConfig](../-email-password-config/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [changePassword](change-password.md) | [common]<br>suspend fun [changePassword](change-password.md)(currentPassword: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), newPassword: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [checkEmailExists](check-email-exists.md) | [common]<br>suspend fun [checkEmailExists](check-email-exists.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
| [requestPasswordReset](request-password-reset.md) | [common]<br>suspend fun [requestPasswordReset](request-password-reset.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [resetPassword](reset-password.md) | [common]<br>suspend fun [resetPassword](reset-password.md)(token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), newPassword: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [signIn](sign-in.md) | [common]<br>suspend fun [signIn](sign-in.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md) |
| [signUp](sign-up.md) | [common]<br>suspend fun [signUp](sign-up.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md) |
