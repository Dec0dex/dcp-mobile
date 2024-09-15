//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.recipes.passwordless](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Passwordless](-passwordless/index.md) | [common]<br>object [Passwordless](-passwordless/index.md) : [RecipeBuilder](../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[PasswordlessConfig](-passwordless-config/index.md), [PasswordlessRecipe](-passwordless-recipe/index.md)&gt; , [SignUpProvider](../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider/index.md)&lt;[Passwordless.SignUpConfig](-passwordless/-sign-up-config/index.md), [PasswordlessSignUpData](-passwordless-sign-up-data/index.md)&gt; |
| [PasswordlessConfig](-passwordless-config/index.md) | [common]<br>class [PasswordlessConfig](-passwordless-config/index.md) : [RecipeConfig](../net.decodex.dcp.core.supertokens.recipes/-recipe-config/index.md) |
| [PasswordlessInputCode](-passwordless-input-code/index.md) | [common]<br>object [PasswordlessInputCode](-passwordless-input-code/index.md) : [SignInProvider](../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[PasswordlessInputCode.SignInConfig](-passwordless-input-code/-sign-in-config/index.md), [SignInData](../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md)&gt; |
| [PasswordlessLinkCode](-passwordless-link-code/index.md) | [common]<br>object [PasswordlessLinkCode](-passwordless-link-code/index.md) : [SignInProvider](../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[PasswordlessLinkCode.SignInConfig](-passwordless-link-code/-sign-in-config/index.md), [SignInData](../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md)&gt; |
| [PasswordlessRecipe](-passwordless-recipe/index.md) | [common]<br>class [PasswordlessRecipe](-passwordless-recipe/index.md)(superTokens: [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [PasswordlessConfig](-passwordless-config/index.md)) : [Recipe](../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[PasswordlessConfig](-passwordless-config/index.md)&gt; |
| [PasswordlessSignUpData](-passwordless-sign-up-data/index.md) | [common]<br>data class [PasswordlessSignUpData](-passwordless-sign-up-data/index.md)(val deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val flowType: [PasswordlessMode](../net.decodex.dcp.core.supertokens.models/-passwordless-mode/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [checkPhoneNumberExists](check-phone-number-exists.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[checkPhoneNumberExists](check-phone-number-exists.md)(phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
