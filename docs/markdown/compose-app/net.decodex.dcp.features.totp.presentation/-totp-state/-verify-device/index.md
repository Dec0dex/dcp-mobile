//[composeApp](../../../../index.md)/[net.decodex.dcp.features.totp.presentation](../../index.md)/[TotpState](../index.md)/[VerifyDevice](index.md)

# VerifyDevice

[common]\
data class [VerifyDevice](index.md)(val totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val secret: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val qrCodeValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [TotpState](../index.md)

## Constructors

| | |
|---|---|
| [VerifyDevice](-verify-device.md) | [common]<br>constructor(totp: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, secret: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, qrCodeValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [deviceName](device-name.md) | [common]<br>val [deviceName](device-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [qrCodeValue](qr-code-value.md) | [common]<br>val [qrCodeValue](qr-code-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [secret](secret.md) | [common]<br>val [secret](secret.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [totp](totp.md) | [common]<br>val [totp](totp.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
