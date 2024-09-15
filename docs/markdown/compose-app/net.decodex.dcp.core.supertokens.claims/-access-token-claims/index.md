//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.claims](../index.md)/[AccessTokenClaims](index.md)

# AccessTokenClaims

[common]\
@Serializable

data class [AccessTokenClaims](index.md)(val expiresAt: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val issuedAt: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val sub: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val issuer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val audience: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val emailVerified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, val phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val roles: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val permissions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val multiFactor: [ClaimMFA](../-claim-m-f-a/index.md)? = null)

## Constructors

| | |
|---|---|
| [AccessTokenClaims](-access-token-claims.md) | [common]<br>constructor(expiresAt: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), issuedAt: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), sub: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), issuer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), audience: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, emailVerified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, phoneNumber: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, roles: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, permissions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, multiFactor: [ClaimMFA](../-claim-m-f-a/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [audience](audience.md) | [common]<br>@SerialName(value = &quot;aud&quot;)<br>@Serializable(with = [StringListSerializer::class](../../net.decodex.dcp.core.utils/-string-list-serializer/index.md))<br>val [audience](audience.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [email](email.md) | [common]<br>@SerialName(value = &quot;email&quot;)<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [emailVerified](email-verified.md) | [common]<br>@SerialName(value = &quot;st-ev&quot;)<br>val [emailVerified](email-verified.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null |
| [expiresAt](expires-at.md) | [common]<br>@SerialName(value = &quot;exp&quot;)<br>val [expiresAt](expires-at.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [issuedAt](issued-at.md) | [common]<br>@SerialName(value = &quot;iat&quot;)<br>val [issuedAt](issued-at.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [issuer](issuer.md) | [common]<br>@SerialName(value = &quot;iss&quot;)<br>val [issuer](issuer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [multiFactor](multi-factor.md) | [common]<br>@SerialName(value = &quot;st-mfa&quot;)<br>val [multiFactor](multi-factor.md): [ClaimMFA](../-claim-m-f-a/index.md)? = null |
| [permissions](permissions.md) | [common]<br>@SerialName(value = &quot;st-perm&quot;)<br>val [permissions](permissions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [phoneNumber](phone-number.md) | [common]<br>@SerialName(value = &quot;phoneNumber&quot;)<br>val [phoneNumber](phone-number.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [roles](roles.md) | [common]<br>@SerialName(value = &quot;st-role&quot;)<br>val [roles](roles.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [sub](sub.md) | [common]<br>@SerialName(value = &quot;sub&quot;)<br>val [sub](sub.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
