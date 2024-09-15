//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.models](../index.md)/[AuthFactor](index.md)

# AuthFactor

sealed interface [AuthFactor](index.md)

#### Inheritors

| |
|---|
| [AnyOf](-any-of/index.md) |
| [AllOf](-all-of/index.md) |

## Types

| Name | Summary |
|---|---|
| [AllOf](-all-of/index.md) | [common]<br>class [AllOf](-all-of/index.md)(factors: [AuthFactor](index.md), val anyOrder: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [AuthFactor](index.md) |
| [AnyOf](-any-of/index.md) | [common]<br>class [AnyOf](-any-of/index.md)(factors: [AuthFactor](index.md)) : [AuthFactor](index.md) |
| [LinkEmail](-link-email/index.md) | [common]<br>data object [LinkEmail](-link-email/index.md) : Factor |
| [LinkPhone](-link-phone/index.md) | [common]<br>data object [LinkPhone](-link-phone/index.md) : Factor |
| [OtpEmail](-otp-email/index.md) | [common]<br>data object [OtpEmail](-otp-email/index.md) : Factor |
| [OtpPhone](-otp-phone/index.md) | [common]<br>data object [OtpPhone](-otp-phone/index.md) : Factor |
| [TOTP](-t-o-t-p/index.md) | [common]<br>data object [TOTP](-t-o-t-p/index.md) : Factor |

## Functions

| Name | Summary |
|---|---|
| [equalsTo](equals-to.md) | [common]<br>open fun [AuthFactor](index.md).[equalsTo](equals-to.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [equalsTo](equals-to.md) | [common]<br>open fun [AuthFactor](index.md).[equalsTo](equals-to.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isValid](is-valid.md) | [common]<br>open fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[AuthFactor](index.md)&gt;.[isValid](is-valid.md)(factors: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Number](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isValidFor](is-valid-for.md) | [common]<br>abstract fun [isValidFor](is-valid-for.md)(factors: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Number](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [missing](missing.md) | [common]<br>open fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[AuthFactor](index.md)&gt;.[missing](missing.md)(factors: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Number](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
