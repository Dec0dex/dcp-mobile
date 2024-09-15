//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[MultiFactorStatusResponseDTO](index.md)

# MultiFactorStatusResponseDTO

[common]\
@Serializable

data class [MultiFactorStatusResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val factors: [FactorsStatusDTO](../-factors-status-d-t-o/index.md)? = null, val emails: [EmailsStatusDTO](../-emails-status-d-t-o/index.md)? = null, val phoneNumbers: [PhoneStatusDTO](../-phone-status-d-t-o/index.md)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [MultiFactorStatusResponseDTO](-multi-factor-status-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, factors: [FactorsStatusDTO](../-factors-status-d-t-o/index.md)? = null, emails: [EmailsStatusDTO](../-emails-status-d-t-o/index.md)? = null, phoneNumbers: [PhoneStatusDTO](../-phone-status-d-t-o/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [emails](emails.md) | [common]<br>val [emails](emails.md): [EmailsStatusDTO](../-emails-status-d-t-o/index.md)? = null |
| [factors](factors.md) | [common]<br>val [factors](factors.md): [FactorsStatusDTO](../-factors-status-d-t-o/index.md)? = null |
| [phoneNumbers](phone-numbers.md) | [common]<br>val [phoneNumbers](phone-numbers.md): [PhoneStatusDTO](../-phone-status-d-t-o/index.md)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
