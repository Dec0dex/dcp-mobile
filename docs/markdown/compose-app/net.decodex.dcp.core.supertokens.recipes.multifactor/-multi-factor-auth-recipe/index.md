//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.multifactor](../index.md)/[MultiFactorAuthRecipe](index.md)

# MultiFactorAuthRecipe

[common]\
class [MultiFactorAuthRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [MultiFactorAuthConfig](../-multi-factor-auth-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[MultiFactorAuthConfig](../-multi-factor-auth-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [MultiFactorAuthRecipe](-multi-factor-auth-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [MultiFactorAuthConfig](../-multi-factor-auth-config/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [checkMfaStatus](check-mfa-status.md) | [common]<br>suspend fun [checkMfaStatus](check-mfa-status.md)(): [MultiFactorAuthStatus](../../net.decodex.dcp.core.supertokens.models/-multi-factor-auth-status/index.md) |
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
