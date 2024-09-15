//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[TokensRepositorySettings](index.md)

# TokensRepositorySettings

[common]\
class [TokensRepositorySettings](index.md)(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;) : [TokensRepository](../-tokens-repository/index.md)

## Constructors

| | |
|---|---|
| [TokensRepositorySettings](-tokens-repository-settings.md) | [common]<br>constructor(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getAccessToken](get-access-token.md) | [common]<br>open suspend override fun [getAccessToken](get-access-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getRefreshToken](get-refresh-token.md) | [common]<br>open suspend override fun [getRefreshToken](get-refresh-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [setAccessToken](set-access-token.md) | [common]<br>open suspend override fun [setAccessToken](set-access-token.md)(accessToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setRefreshToken](set-refresh-token.md) | [common]<br>open suspend override fun [setRefreshToken](set-refresh-token.md)(refreshToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
