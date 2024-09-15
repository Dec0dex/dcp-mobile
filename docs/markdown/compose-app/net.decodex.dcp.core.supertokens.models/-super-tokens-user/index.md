//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.models](../index.md)/[SuperTokensUser](index.md)

# SuperTokensUser

[common]\
@Serializable

data class [SuperTokensUser](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val isPrimaryUser: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, val tenantIds: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val emails: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val phoneNumbers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val timeJoined: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val thirdParty: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ThirdParty](../-third-party/index.md)&gt;? = null, val loginMethods: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[LoginMethod](../-login-method/index.md)&gt;? = null, val recipeUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

## Constructors

| | |
|---|---|
| [SuperTokensUser](-super-tokens-user.md) | [common]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isPrimaryUser: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, tenantIds: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, emails: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, phoneNumbers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, timeJoined: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), thirdParty: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ThirdParty](../-third-party/index.md)&gt;? = null, loginMethods: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[LoginMethod](../-login-method/index.md)&gt;? = null, recipeUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [email](email.md) | [common]<br>val [~~email~~](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [emails](emails.md) | [common]<br>val [emails](emails.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [id](id.md) | [common]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isEmailPassword](../is-email-password.md) | [common]<br>val [SuperTokensUser](index.md).[isEmailPassword](../is-email-password.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPasswordless](../is-passwordless.md) | [common]<br>val [SuperTokensUser](index.md).[isPasswordless](../is-passwordless.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPrimaryUser](is-primary-user.md) | [common]<br>val [isPrimaryUser](is-primary-user.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null |
| [isThirdParty](../is-third-party.md) | [common]<br>val [SuperTokensUser](index.md).[isThirdParty](../is-third-party.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loginMethods](login-methods.md) | [common]<br>val [loginMethods](login-methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[LoginMethod](../-login-method/index.md)&gt;? = null |
| [phoneNumber](phone-number.md) | [common]<br>val [~~phoneNumber~~](phone-number.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [phoneNumbers](phone-numbers.md) | [common]<br>val [phoneNumbers](phone-numbers.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [recipeUserId](recipe-user-id.md) | [common]<br>val [recipeUserId](recipe-user-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [tenantIds](tenant-ids.md) | [common]<br>val [tenantIds](tenant-ids.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [thirdParty](third-party.md) | [common]<br>val [thirdParty](third-party.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ThirdParty](../-third-party/index.md)&gt;? = null |
| [timeJoined](time-joined.md) | [common]<br>val [timeJoined](time-joined.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
