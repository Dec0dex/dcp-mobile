//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SuperTokensClient](-super-tokens-client/index.md) | [common]<br>class [SuperTokensClient](-super-tokens-client/index.md)(config: [SuperTokensClientConfig](-super-tokens-client-config/index.md)) |
| [SuperTokensClientConfig](-super-tokens-client-config/index.md) | [common]<br>class [SuperTokensClientConfig](-super-tokens-client-config/index.md)(val apiBaseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, val engine: HttpClientEngine, val logLevel: LogLevel) |
| [SuperTokensDslMarker](-super-tokens-dsl-marker/index.md) | [common]<br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-dsl-marker/index.html)<br>annotation class [SuperTokensDslMarker](-super-tokens-dsl-marker/index.md) |

## Functions

| Name | Summary |
|---|---|
| [superTokensClient](super-tokens-client.md) | [common]<br>fun [superTokensClient](super-tokens-client.md)(apiBaseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), engine: HttpClientEngine, dataStore: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;, logLevel: LogLevel = LogLevel.ALL, init: [SuperTokensClientConfig](-super-tokens-client-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}): [SuperTokensClient](-super-tokens-client/index.md) |
