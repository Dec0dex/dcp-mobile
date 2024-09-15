//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens](../index.md)/[SuperTokensClient](index.md)

# SuperTokensClient

[common]\
class [SuperTokensClient](index.md)(config: [SuperTokensClientConfig](../-super-tokens-client-config/index.md))

## Constructors

| | |
|---|---|
| [SuperTokensClient](-super-tokens-client.md) | [common]<br>constructor(config: [SuperTokensClientConfig](../-super-tokens-client-config/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [apiClient](api-client.md) | [common]<br>val [apiClient](api-client.md): HttpClient |
| [authRepository](auth-repository.md) | [common]<br>val [authRepository](auth-repository.md): [AuthRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-auth-repository/index.md) |
| [claimsRepository](claims-repository.md) | [common]<br>val [claimsRepository](claims-repository.md): [ClaimsRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-claims-repository/index.md) |
| [isInitialized](is-initialized.md) | [common]<br>val [isInitialized](is-initialized.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt; |
| [recipes](recipes.md) | [common]<br>val [recipes](recipes.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;*&gt;&gt; |
| [settings](settings.md) | [common]<br>val [settings](settings.md): [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt; |
| [tenantId](tenant-id.md) | [common]<br>val [tenantId](tenant-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [tokenRepository](token-repository.md) | [common]<br>val [tokenRepository](token-repository.md): [TokensRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-tokens-repository/index.md) |
| [userRepository](user-repository.md) | [common]<br>val [userRepository](user-repository.md): [SuperTokensUserRepository](../../net.decodex.dcp.core.supertokens.recipes.core.repositories/-super-tokens-user-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [checkEmailExists](../../net.decodex.dcp.core.supertokens.recipes.core/check-email-exists.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[checkEmailExists](../../net.decodex.dcp.core.supertokens.recipes.core/check-email-exists.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), recipeId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = RECIPE_EMAIL_PASSWORD): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [checkEmailVerified](../../net.decodex.dcp.core.supertokens.recipes.emailverification/check-email-verified.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[checkEmailVerified](../../net.decodex.dcp.core.supertokens.recipes.emailverification/check-email-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [checkPhoneNumberExists](../../net.decodex.dcp.core.supertokens.recipes.passwordless/check-phone-number-exists.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[checkPhoneNumberExists](../../net.decodex.dcp.core.supertokens.recipes.passwordless/check-phone-number-exists.md)(phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getAccessToken](../../net.decodex.dcp.core.supertokens.recipes.session.repository/get-access-token.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[getAccessToken](../../net.decodex.dcp.core.supertokens.recipes.session.repository/get-access-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getRecipe](get-recipe.md) | [common]<br>inline fun &lt;[T](get-recipe.md) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;*&gt;&gt; [getRecipe](get-recipe.md)(): [T](get-recipe.md) |
| [getRefreshToken](../../net.decodex.dcp.core.supertokens.recipes.session.repository/get-refresh-token.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[getRefreshToken](../../net.decodex.dcp.core.supertokens.recipes.session.repository/get-refresh-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getThirdPartyAuthorizationUrl](../../net.decodex.dcp.core.supertokens.recipes.thirdparty/get-third-party-authorization-url.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[getThirdPartyAuthorizationUrl](../../net.decodex.dcp.core.supertokens.recipes.thirdparty/get-third-party-authorization-url.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hasRecipe](has-recipe.md) | [common]<br>inline fun &lt;[T](has-recipe.md) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;*&gt;&gt; [hasRecipe](has-recipe.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isAuthenticated](is-authenticated.md) | [common]<br>fun [isAuthenticated](is-authenticated.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isLoggedIn](is-logged-in.md) | [common]<br>fun [isLoggedIn](is-logged-in.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>true, if the the user is at least logged in (but may not be authenticated from the backend yet) It essentially means, there is a refresh token present, but no access token yet, e.g. during startup when a new access token hasn't been fetched yet. |
| [sendVerificationEmail](../../net.decodex.dcp.core.supertokens.recipes.emailverification/send-verification-email.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[sendVerificationEmail](../../net.decodex.dcp.core.supertokens.recipes.emailverification/send-verification-email.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [signInWith](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md) | [common]<br>suspend fun &lt;[C](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md), [Provider](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md) : [SignInProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[C](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md), [R](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md)&gt;, [R](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md)&gt; [SuperTokensClient](index.md).[signInWith](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md)(provider: [Provider](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md), config: [C](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](../../net.decodex.dcp.core.supertokens.handlers/sign-in-with.md) |
| [signOut](../../net.decodex.dcp.core.supertokens.recipes.session/sign-out.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[signOut](../../net.decodex.dcp.core.supertokens.recipes.session/sign-out.md)(clearServerSession: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |
| [signUpWith](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md) | [common]<br>suspend fun &lt;[C](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md), [Provider](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md) : [SignUpProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider/index.md)&lt;[C](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md), [R](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md)&gt;, [R](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md)&gt; [SuperTokensClient](index.md).[signUpWith](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md)(provider: [Provider](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md), config: [C](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [R](../../net.decodex.dcp.core.supertokens.handlers/sign-up-with.md) |
| [verifyEmail](../../net.decodex.dcp.core.supertokens.recipes.emailverification/verify-email.md) | [common]<br>suspend fun [SuperTokensClient](index.md).[verifyEmail](../../net.decodex.dcp.core.supertokens.recipes.emailverification/verify-email.md)(token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
