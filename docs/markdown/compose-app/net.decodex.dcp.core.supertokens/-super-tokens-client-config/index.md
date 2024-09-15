//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens](../index.md)/[SuperTokensClientConfig](index.md)

# SuperTokensClientConfig

[common]\
class [SuperTokensClientConfig](index.md)(val apiBaseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, val engine: HttpClientEngine, val logLevel: LogLevel)

## Constructors

| | |
|---|---|
| [SuperTokensClientConfig](-super-tokens-client-config.md) | [common]<br>constructor(apiBaseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, engine: HttpClientEngine, logLevel: LogLevel) |

## Properties

| Name | Summary |
|---|---|
| [apiBaseUrl](api-base-url.md) | [common]<br>val [apiBaseUrl](api-base-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [client](client.md) | [common]<br>var [client](client.md): HttpClient |
| [clientName](client-name.md) | [common]<br>var [clientName](client-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [dataStore](data-store.md) | [common]<br>val [dataStore](data-store.md): [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt; |
| [engine](engine.md) | [common]<br>val [engine](engine.md): HttpClientEngine |
| [logLevel](log-level.md) | [common]<br>val [logLevel](log-level.md): LogLevel |
| [recipes](recipes.md) | [common]<br>var [recipes](recipes.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[BuildRecipe](../../net.decodex.dcp.core.supertokens.recipes/-build-recipe/index.md)&gt; |
| [scope](scope.md) | [common]<br>val [scope](scope.md): CoroutineScope |
| [tenantId](tenant-id.md) | [common]<br>var [tenantId](tenant-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [userRepository](user-repository.md) | [common]<br>var [userRepository](user-repository.md): [SuperTokensUserRepository](../../net.decodex.dcp.core.supertokens.recipes.core.repositories/-super-tokens-user-repository/index.md)? |

## Functions

| Name | Summary |
|---|---|
| [recipe](recipe.md) | [common]<br>fun &lt;[C](recipe.md) : [RecipeConfig](../../net.decodex.dcp.core.supertokens.recipes/-recipe-config/index.md), [R](recipe.md) : [Recipe](../../net.decodex.dcp.core.supertokens.recipes/-recipe/index.md)&lt;[C](recipe.md)&gt;&gt; [recipe](recipe.md)(builder: [RecipeBuilder](../../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[C](recipe.md), [R](recipe.md)&gt;, configure: [C](recipe.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}) |
| [unaryPlus](unary-plus.md) | [common]<br>operator fun [BuildRecipe](../../net.decodex.dcp.core.supertokens.recipes/-build-recipe/index.md).[unaryPlus](unary-plus.md)() |
