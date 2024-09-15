//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[ClaimsRepositoryMemory](index.md)

# ClaimsRepositoryMemory

[common]\
class [ClaimsRepositoryMemory](index.md) : [ClaimsRepository](../-claims-repository/index.md)

## Constructors

| | |
|---|---|
| [ClaimsRepositoryMemory](-claims-repository-memory.md) | [common]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [claims](claims.md) | [common]<br>open override val [claims](claims.md): MutableStateFlow&lt;[AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)?&gt; |
| [decoder](decoder.md) | [common]<br>open override val [decoder](decoder.md): Json |

## Functions

| Name | Summary |
|---|---|
| [clear](../-claims-repository/clear.md) | [common]<br>open suspend fun [clear](../-claims-repository/clear.md)() |
| [getClaims](get-claims.md) | [common]<br>open suspend override fun [getClaims](get-claims.md)(): [AccessTokenClaims](../../net.decodex.dcp.core.supertokens.claims/-access-token-claims/index.md)? |
| [getEmail](../-claims-repository/get-email.md) | [common]<br>open suspend fun [getEmail](../-claims-repository/get-email.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getFactors](../-claims-repository/get-factors.md) | [common]<br>open suspend fun [getFactors](../-claims-repository/get-factors.md)(): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt; |
| [getPermissions](../-claims-repository/get-permissions.md) | [common]<br>open suspend fun [getPermissions](../-claims-repository/get-permissions.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getRoles](../-claims-repository/get-roles.md) | [common]<br>open suspend fun [getRoles](../-claims-repository/get-roles.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getUserId](../-claims-repository/get-user-id.md) | [common]<br>open suspend fun [getUserId](../-claims-repository/get-user-id.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [isEmailVerified](../-claims-repository/is-email-verified.md) | [common]<br>open suspend fun [isEmailVerified](../-claims-repository/is-email-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isMultiFactorVerified](../-claims-repository/is-multi-factor-verified.md) | [common]<br>open suspend fun [isMultiFactorVerified](../-claims-repository/is-multi-factor-verified.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [setClaims](set-claims.md) | [common]<br>open suspend override fun [setClaims](set-claims.md)(claims: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setClaimsFromJwt](../-claims-repository/set-claims-from-jwt.md) | [common]<br>open suspend fun [setClaimsFromJwt](../-claims-repository/set-claims-from-jwt.md)(jwt: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
