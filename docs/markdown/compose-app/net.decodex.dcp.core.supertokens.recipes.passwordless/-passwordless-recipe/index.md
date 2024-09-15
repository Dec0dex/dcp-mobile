//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.passwordless](../index.md)/[PasswordlessRecipe](index.md)

# PasswordlessRecipe

[common]\
class [PasswordlessRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [PasswordlessConfig](../-passwordless-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[PasswordlessConfig](../-passwordless-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [PasswordlessRecipe](-passwordless-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [PasswordlessConfig](../-passwordless-config/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [checkEmailExists](check-email-exists.md) | [common]<br>suspend fun [checkEmailExists](check-email-exists.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [checkPhoneNumberExists](check-phone-number-exists.md) | [common]<br>suspend fun [checkPhoneNumberExists](check-phone-number-exists.md)(phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
| [signInInputCode](sign-in-input-code.md) | [common]<br>suspend fun [signInInputCode](sign-in-input-code.md)(preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), userInputCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
| [signInLinkCode](sign-in-link-code.md) | [common]<br>suspend fun [signInLinkCode](sign-in-link-code.md)(preAuthSessionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), linkCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SignInData](../../net.decodex.dcp.core.supertokens.models/-sign-in-data/index.md) |
| [signUpEmail](sign-up-email.md) | [common]<br>suspend fun [signUpEmail](sign-up-email.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [PasswordlessSignUpData](../-passwordless-sign-up-data/index.md) |
| [signUpPhoneNumber](sign-up-phone-number.md) | [common]<br>suspend fun [signUpPhoneNumber](sign-up-phone-number.md)(phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [PasswordlessSignUpData](../-passwordless-sign-up-data/index.md) |
