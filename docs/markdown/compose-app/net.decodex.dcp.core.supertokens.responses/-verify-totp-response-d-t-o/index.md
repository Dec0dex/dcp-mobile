//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[VerifyTotpResponseDTO](index.md)

# VerifyTotpResponseDTO

[common]\
@Serializable

data class [VerifyTotpResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val currentNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val maxNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val retryAfterMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [VerifyTotpResponseDTO](-verify-totp-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, currentNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, maxNumberOfFailedAttempts: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, retryAfterMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [currentNumberOfFailedAttempts](current-number-of-failed-attempts.md) | [common]<br>val [currentNumberOfFailedAttempts](current-number-of-failed-attempts.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null |
| [maxNumberOfFailedAttempts](max-number-of-failed-attempts.md) | [common]<br>val [maxNumberOfFailedAttempts](max-number-of-failed-attempts.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null |
| [retryAfterMs](retry-after-ms.md) | [common]<br>val [retryAfterMs](retry-after-ms.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
