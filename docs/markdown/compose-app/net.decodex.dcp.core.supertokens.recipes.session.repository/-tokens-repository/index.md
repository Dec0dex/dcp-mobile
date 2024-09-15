//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[TokensRepository](index.md)

# TokensRepository

abstract class [TokensRepository](index.md)

#### Inheritors

| |
|---|
| [TokensRepositoryMemory](../-tokens-repository-memory/index.md) |
| [TokensRepositorySettings](../-tokens-repository-settings/index.md) |

## Constructors

| | |
|---|---|
| [TokensRepository](-tokens-repository.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getAccessToken](get-access-token.md) | [common]<br>abstract suspend fun [getAccessToken](get-access-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getRefreshToken](get-refresh-token.md) | [common]<br>abstract suspend fun [getRefreshToken](get-refresh-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [setAccessToken](set-access-token.md) | [common]<br>abstract suspend fun [setAccessToken](set-access-token.md)(accessToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setRefreshToken](set-refresh-token.md) | [common]<br>abstract suspend fun [setRefreshToken](set-refresh-token.md)(refreshToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
