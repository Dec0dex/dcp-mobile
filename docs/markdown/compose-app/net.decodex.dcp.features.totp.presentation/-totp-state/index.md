//[composeApp](../../../index.md)/[net.decodex.dcp.features.totp.presentation](../index.md)/[TotpState](index.md)

# TotpState

sealed interface [TotpState](index.md)

#### Inheritors

| |
|---|
| [Loading](-loading/index.md) |
| [AddDevice](-add-device/index.md) |
| [EnterTotp](-enter-totp/index.md) |
| [Error](-error/index.md) |
| [VerifyDevice](-verify-device/index.md) |

## Types

| Name | Summary |
|---|---|
| [AddDevice](-add-device/index.md) | [common]<br>data class [AddDevice](-add-device/index.md)(val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [TotpState](index.md) |
| [EnterTotp](-enter-totp/index.md) | [common]<br>data class [EnterTotp](-enter-totp/index.md)(val totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [TotpState](index.md) |
| [Error](-error/index.md) | [common]<br>data class [Error](-error/index.md)(val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val isDialogVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) : [TotpState](index.md) |
| [Loading](-loading/index.md) | [common]<br>data object [Loading](-loading/index.md) : [TotpState](index.md) |
| [VerifyDevice](-verify-device/index.md) | [common]<br>data class [VerifyDevice](-verify-device/index.md)(val totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val secret: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val qrCodeValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [TotpState](index.md) |
