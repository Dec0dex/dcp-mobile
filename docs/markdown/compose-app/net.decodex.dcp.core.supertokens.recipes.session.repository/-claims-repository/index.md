//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[ClaimsRepository](index.md)

# ClaimsRepository

interface [ClaimsRepository](index.md)

#### Inheritors

| |
|---|
| [ClaimsRepositoryMemory](../-claims-repository-memory/index.md) |
| [ClaimsRepositorySettings](../-claims-repository-settings/index.md) |

## Properties

| Name | Summary |
|---|---|
| [claims](claims.md) | [common]<br>abstract val [claims](claims.md): StateFlow&lt;[AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)?&gt; |
| [decoder](decoder.md) | [common]<br>abstract val [decoder](decoder.md): StringFormat |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [common]<br>open suspend fun [clear](clear.md)() |
| [getClaims](get-claims.md) | [common]<br>abstract suspend fun [getClaims](get-claims.md)(): [AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? |
| [getEmail](get-email.md) | [common]<br>open suspend fun [getEmail](get-email.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getFactors](get-factors.md) | [common]<br>open suspend fun [getFactors](get-factors.md)(): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt; |
| [getPermissions](get-permissions.md) | [common]<br>open suspend fun [getPermissions](get-permissions.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getRoles](get-roles.md) | [common]<br>open suspend fun [getRoles](get-roles.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getUserId](get-user-id.md) | [common]<br>open suspend fun [getUserId](get-user-id.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [isEmailVerified](is-email-verified.md) | [common]<br>open suspend fun [isEmailVerified](is-email-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isMultiFactorVerified](is-multi-factor-verified.md) | [common]<br>open suspend fun [isMultiFactorVerified](is-multi-factor-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [setClaims](set-claims.md) | [common]<br>abstract suspend fun [setClaims](set-claims.md)(claims: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setClaimsFromJwt](set-claims-from-jwt.md) | [common]<br>open suspend fun [setClaimsFromJwt](set-claims-from-jwt.md)(jwt: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
