//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.responses](../index.md)/[AuthorizationUrlResponseDTO](index.md)

# AuthorizationUrlResponseDTO

[common]\
@Serializable

data class [AuthorizationUrlResponseDTO](index.md)(val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, val urlWithQueryParams: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val pkceCodeVerifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SuperTokensBaseResponseDTO](../-super-tokens-base-response-d-t-o/index.md)

## Constructors

| | |
|---|---|
| [AuthorizationUrlResponseDTO](-authorization-url-response-d-t-o.md) | [common]<br>constructor(status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = SuperTokensStatus.OK.value, urlWithQueryParams: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, pkceCodeVerifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [pkceCodeVerifier](pkce-code-verifier.md) | [common]<br>val [pkceCodeVerifier](pkce-code-verifier.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [status](status.md) | [common]<br>open override val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [urlWithQueryParams](url-with-query-params.md) | [common]<br>val [urlWithQueryParams](url-with-query-params.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
