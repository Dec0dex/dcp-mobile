//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.totp](../index.md)/[TotpRecipe](index.md)

# TotpRecipe

[common]\
class [TotpRecipe](index.md)(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [TotpConfig](../-totp-config/index.md)) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[TotpConfig](../-totp-config/index.md)&gt;

## Constructors

| | |
|---|---|
| [TotpRecipe](-totp-recipe.md) | [common]<br>constructor(superTokens: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), config: [TotpConfig](../-totp-config/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md) | [common]<br>open fun HttpClientConfig&lt;*&gt;.[configureClient](../../net.decodex.dcp.core.supertokens.recipes/-recipe/configure-client.md)() |
| [createDevice](create-device.md) | [common]<br>suspend fun [createDevice](create-device.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CreateTotpDeviceResult](../../net.decodex.dcp.core.supertokens.recipes.totp.usecases/-create-totp-device-result/index.md) |
| [getDevices](get-devices.md) | [common]<br>suspend fun [getDevices](get-devices.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TotpDevice](../../net.decodex.dcp.core.supertokens.models/-totp-device/index.md)&gt; |
| [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md) | [common]<br>open suspend fun [postInit](../../net.decodex.dcp.core.supertokens.recipes/-recipe/post-init.md)() |
| [removeDevice](remove-device.md) | [common]<br>suspend fun [removeDevice](remove-device.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [verify](verify.md) | [common]<br>suspend fun [verify](verify.md)(totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [verifyDevice](verify-device.md) | [common]<br>suspend fun [verifyDevice](verify-device.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SuperTokensStatus](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status/index.md) |
