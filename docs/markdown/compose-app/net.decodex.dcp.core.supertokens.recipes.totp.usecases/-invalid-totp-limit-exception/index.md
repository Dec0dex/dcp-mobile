//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.totp.usecases](../index.md)/[InvalidTotpLimitException](index.md)

# InvalidTotpLimitException

[common]\
data class [InvalidTotpLimitException](index.md)(val retryAfterMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [SuperTokensStatusException](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/index.md)

## Constructors

| | |
|---|---|
| [InvalidTotpLimitException](-invalid-totp-limit-exception.md) | [common]<br>constructor(retryAfterMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cause](index.md#-654012527%2FProperties%2F-676342820) | [common]<br>open val [cause](index.md#-654012527%2FProperties%2F-676342820): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? |
| [message](index.md#1824300659%2FProperties%2F-676342820) | [common]<br>open val [message](index.md#1824300659%2FProperties%2F-676342820): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [retryAfterMs](retry-after-ms.md) | [common]<br>val [retryAfterMs](retry-after-ms.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [status](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/status.md) | [common]<br>val [status](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status-exception/status.md): [SuperTokensStatus](../../net.decodex.dcp.core.supertokens.common/-super-tokens-status/index.md) |
