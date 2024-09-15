//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.recipes.totp.usecases](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CreateTotpDeviceResult](-create-totp-device-result/index.md) | [common]<br>data class [CreateTotpDeviceResult](-create-totp-device-result/index.md)(val deviceName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val qrCodeString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val secret: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [InvalidTotpException](-invalid-totp-exception/index.md) | [common]<br>data class [InvalidTotpException](-invalid-totp-exception/index.md)(val currentNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val maxNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [SuperTokensStatusException](../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/index.md) |
| [InvalidTotpLimitException](-invalid-totp-limit-exception/index.md) | [common]<br>data class [InvalidTotpLimitException](-invalid-totp-limit-exception/index.md)(val retryAfterMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [SuperTokensStatusException](../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/index.md) |
