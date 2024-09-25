//[composeApp](../../../index.md)/[net.decodex.dcp.features.totp.presentation](../index.md)/[TotpEvent](index.md)

# TotpEvent

sealed interface [TotpEvent](index.md)

#### Inheritors

| |
|---|
| [GoBack](-go-back/index.md) |
| [OnDismissErrorDialog](-on-dismiss-error-dialog/index.md) |
| [OnTotpChange](-on-totp-change/index.md) |
| [OnDeviceNameChange](-on-device-name-change/index.md) |
| [CreateDevice](-create-device/index.md) |
| [Verify](-verify/index.md) |

## Types

| Name | Summary |
|---|---|
| [CreateDevice](-create-device/index.md) | [common]<br>data class [CreateDevice](-create-device/index.md)(val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [TotpEvent](index.md) |
| [GoBack](-go-back/index.md) | [common]<br>data object [GoBack](-go-back/index.md) : [TotpEvent](index.md) |
| [OnDeviceNameChange](-on-device-name-change/index.md) | [common]<br>data class [OnDeviceNameChange](-on-device-name-change/index.md)(val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [TotpEvent](index.md) |
| [OnDismissErrorDialog](-on-dismiss-error-dialog/index.md) | [common]<br>data object [OnDismissErrorDialog](-on-dismiss-error-dialog/index.md) : [TotpEvent](index.md) |
| [OnTotpChange](-on-totp-change/index.md) | [common]<br>data class [OnTotpChange](-on-totp-change/index.md)(val totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [TotpEvent](index.md) |
| [Verify](-verify/index.md) | [common]<br>data class [Verify](-verify/index.md)(val totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [TotpEvent](index.md) |
