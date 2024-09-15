//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.models](../index.md)/[LoginMethod](index.md)

# LoginMethod

[common]\
@Serializable

data class [LoginMethod](index.md)(val tenantIds: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val recipeUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val timeJoined: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val recipeId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val thirdParty: [ThirdParty](../-third-party/index.md)? = null)

## Constructors

| | |
|---|---|
| [LoginMethod](-login-method.md) | [common]<br>constructor(tenantIds: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, recipeUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), timeJoined: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), recipeId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, thirdParty: [ThirdParty](../-third-party/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [email](email.md) | [common]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [phoneNumber](phone-number.md) | [common]<br>val [phoneNumber](phone-number.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [recipeId](recipe-id.md) | [common]<br>val [recipeId](recipe-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [recipeUserId](recipe-user-id.md) | [common]<br>val [recipeUserId](recipe-user-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [tenantIds](tenant-ids.md) | [common]<br>val [tenantIds](tenant-ids.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [thirdParty](third-party.md) | [common]<br>val [thirdParty](third-party.md): [ThirdParty](../-third-party/index.md)? = null |
| [timeJoined](time-joined.md) | [common]<br>val [timeJoined](time-joined.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [verified](verified.md) | [common]<br>val [verified](verified.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
