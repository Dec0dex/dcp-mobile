//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AuthRepository](-auth-repository/index.md) | [common]<br>interface [AuthRepository](-auth-repository/index.md) |
| [AuthRepositoryImpl](-auth-repository-impl/index.md) | [common]<br>class [AuthRepositoryImpl](-auth-repository-impl/index.md) : [AuthRepository](-auth-repository/index.md) |
| [AuthState](-auth-state/index.md) | [common]<br>sealed class [AuthState](-auth-state/index.md) |
| [ClaimsRepository](-claims-repository/index.md) | [common]<br>interface [ClaimsRepository](-claims-repository/index.md) |
| [ClaimsRepositoryMemory](-claims-repository-memory/index.md) | [common]<br>class [ClaimsRepositoryMemory](-claims-repository-memory/index.md) : [ClaimsRepository](-claims-repository/index.md) |
| [ClaimsRepositorySettings](-claims-repository-settings/index.md) | [common]<br>class [ClaimsRepositorySettings](-claims-repository-settings/index.md)(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, val decoder: Json = Json {             isLenient = true             explicitNulls = false             encodeDefaults = true             ignoreUnknownKeys = true         }, scope: CoroutineScope) : [ClaimsRepository](-claims-repository/index.md) |
| [TokensRepository](-tokens-repository/index.md) | [common]<br>abstract class [TokensRepository](-tokens-repository/index.md) |
| [TokensRepositoryMemory](-tokens-repository-memory/index.md) | [common]<br>class [TokensRepositoryMemory](-tokens-repository-memory/index.md) : [TokensRepository](-tokens-repository/index.md) |
| [TokensRepositorySettings](-tokens-repository-settings/index.md) | [common]<br>class [TokensRepositorySettings](-tokens-repository-settings/index.md)(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;) : [TokensRepository](-tokens-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getAccessToken](get-access-token.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[getAccessToken](get-access-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getRefreshToken](get-refresh-token.md) | [common]<br>suspend fun [SuperTokensClient](../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md).[getRefreshToken](get-refresh-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
