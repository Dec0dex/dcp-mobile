//[composeApp](../../index.md)/[net.decodex.dcp.core.networking](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AuthHttpClient](-auth-http-client/index.md) | [common]<br>typealias [AuthHttpClient](-auth-http-client/index.md) = HttpClient |
| [NoAuthHttpClient](-no-auth-http-client/index.md) | [common]<br>typealias [NoAuthHttpClient](-no-auth-http-client/index.md) = HttpClient |

## Functions

| Name | Summary |
|---|---|
| [createAuthHttpClient](create-auth-http-client.md) | [common]<br>fun [createAuthHttpClient](create-auth-http-client.md)(engine: HttpClientEngine, preferences: [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;): [AuthHttpClient](-auth-http-client/index.md) |
| [createHttpClient](create-http-client.md) | [common]<br>fun [createHttpClient](create-http-client.md)(engine: HttpClientEngine, additionalConfig: HttpClientConfig&lt;*&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}): [NoAuthHttpClient](-no-auth-http-client/index.md) |
