//[composeApp](../../../index.md)/[net.decodex.dcp.features.emailotp.presnetation](../index.md)/[OtpEvent](index.md)

# OtpEvent

sealed interface [OtpEvent](index.md)

#### Inheritors

| |
|---|
| [SendOtp](-send-otp/index.md) |
| [GoBack](-go-back/index.md) |
| [ConfirmCode](-confirm-code/index.md) |
| [DismissErrorDialog](-dismiss-error-dialog/index.md) |
| [OnCodeInput](-on-code-input/index.md) |

## Types

| Name | Summary |
|---|---|
| [ConfirmCode](-confirm-code/index.md) | [common]<br>data object [ConfirmCode](-confirm-code/index.md) : [OtpEvent](index.md) |
| [DismissErrorDialog](-dismiss-error-dialog/index.md) | [common]<br>data object [DismissErrorDialog](-dismiss-error-dialog/index.md) : [OtpEvent](index.md) |
| [GoBack](-go-back/index.md) | [common]<br>data object [GoBack](-go-back/index.md) : [OtpEvent](index.md) |
| [OnCodeInput](-on-code-input/index.md) | [common]<br>data class [OnCodeInput](-on-code-input/index.md)(val code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [OtpEvent](index.md) |
| [SendOtp](-send-otp/index.md) | [common]<br>data object [SendOtp](-send-otp/index.md) : [OtpEvent](index.md) |
