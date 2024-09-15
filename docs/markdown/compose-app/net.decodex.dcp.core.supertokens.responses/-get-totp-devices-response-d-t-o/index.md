//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[GetTotpDevicesResponseDTO](index.md)

# GetTotpDevicesResponseDTO

[common]\
@Serializable

data class [GetTotpDevicesResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val devices: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TotpDeviceDTO](../-totp-device-d-t-o/index.md)&gt;? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [GetTotpDevicesResponseDTO](-get-totp-devices-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, devices: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TotpDeviceDTO](../-totp-device-d-t-o/index.md)&gt;? = null) |

## Properties

| Name | Summary |
|---|---|
| [devices](devices.md) | [common]<br>val [devices](devices.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TotpDeviceDTO](../-totp-device-d-t-o/index.md)&gt;? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
