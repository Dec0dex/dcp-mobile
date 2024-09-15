//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.totp.usecases](../index.md)/[InvalidTotpException](index.md)

# InvalidTotpException

[common]\
data class [InvalidTotpException](index.md)(val currentNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val maxNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [SuperTokensStatusException](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/index.md)

## Constructors

| | |
|---|---|
| [InvalidTotpException](-invalid-totp-exception.md) | [common]<br>constructor(currentNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), maxNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cause](../-invalid-totp-limit-exception/index.md#-654012527%2FProperties%2F-676342820) | [common]<br>open val [cause](../-invalid-totp-limit-exception/index.md#-654012527%2FProperties%2F-676342820): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? |
| [currentNumberOfFailedAttempts](current-number-of-failed-attempts.md) | [common]<br>val [currentNumberOfFailedAttempts](current-number-of-failed-attempts.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [maxNumberOfFailedAttempts](max-number-of-failed-attempts.md) | [common]<br>val [maxNumberOfFailedAttempts](max-number-of-failed-attempts.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [message](../-invalid-totp-limit-exception/index.md#1824300659%2FProperties%2F-676342820) | [common]<br>open val [message](../-invalid-totp-limit-exception/index.md#1824300659%2FProperties%2F-676342820): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [status](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/status.md) | [common]<br>val [status](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/status.md): [SuperTokensStatus](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status/index.md) |
