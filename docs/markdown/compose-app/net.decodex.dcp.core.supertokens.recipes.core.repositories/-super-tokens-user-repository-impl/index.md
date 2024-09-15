//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.core.repositories](../index.md)/[SuperTokensUserRepositoryImpl](index.md)

# SuperTokensUserRepositoryImpl

[common]\
class [SuperTokensUserRepositoryImpl](index.md)(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, json: Json = Json {
            isLenient = true
            explicitNulls = false
            encodeDefaults = true
            ignoreUnknownKeys = true
        }, scope: CoroutineScope) : [SuperTokensUserRepository](../-super-tokens-user-repository/index.md)

## Constructors

| | |
|---|---|
| [SuperTokensUserRepositoryImpl](-super-tokens-user-repository-impl.md) | [common]<br>constructor(settings: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, json: Json = Json {             isLenient = true             explicitNulls = false             encodeDefaults = true             ignoreUnknownKeys = true         }, scope: CoroutineScope) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [superTokensUser](super-tokens-user.md) | [common]<br>open override val [superTokensUser](super-tokens-user.md): MutableStateFlow&lt;[SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?&gt; |

## Functions

| Name | Summary |
|---|---|
| [getUser](get-user.md) | [common]<br>open suspend override fun [getUser](get-user.md)(): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? |
| [updateUser](update-user.md) | [common]<br>open suspend override fun [updateUser](update-user.md)(user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?) |
