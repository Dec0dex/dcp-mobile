//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session](../index.md)/[SessionRecipe](index.md)

# SessionRecipe

[common]\
class [SessionRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [SessionRecipeConfig](../-session-recipe-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[SessionRecipeConfig](../-session-recipe-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [SessionRecipe](-session-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [SessionRecipeConfig](../-session-recipe-config/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [authRepository](auth-repository.md) | [common]<br>val [authRepository](auth-repository.md): [AuthRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-auth-repository/index.md) |
| [claimsRepository](claims-repository.md) | [common]<br>val [claimsRepository](claims-repository.md): [ClaimsRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-claims-repository/index.md) |
| [tokensRepository](tokens-repository.md) | [common]<br>val [tokensRepository](tokens-repository.md): [TokensRepository](../../net.decodex.dcp.core.supertokens.recipes.session.repository/-tokens-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [configureClient](configure-client.md) | [common]<br>open override fun HttpClientConfig&lt;*&gt;.[configureClient](configure-client.md)() |
| [postInit](post-init.md) | [common]<br>open suspend override fun [postInit](post-init.md)() |
| [refreshTokens](refresh-tokens.md) | [common]<br>suspend fun [refreshTokens](refresh-tokens.md)(): BearerTokens? |
| [signOut](sign-out.md) | [common]<br>suspend fun [signOut](sign-out.md)(clearServerSession: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |
