//[composeApp](../../index.md)/[[root]](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [RedirectUriInfoDTO](-redirect-uri-info-d-t-o/index.md) | [common]<br>@Serializable<br>data class [RedirectUriInfoDTO](-redirect-uri-info-d-t-o/index.md)(val redirectURIOnProviderDashboard: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val redirectURIQueryParams: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, val pkceCodeVerifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [ThirdPartySignInUpRequestDTO](-third-party-sign-in-up-request-d-t-o/index.md) | [common]<br>@Serializable<br>data class [ThirdPartySignInUpRequestDTO](-third-party-sign-in-up-request-d-t-o/index.md)(val thirdPartyId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val redirectURIInfo: [RedirectUriInfoDTO](-redirect-uri-info-d-t-o/index.md)? = null, val oAuthTokens: [ThirdPartyTokensDTO](../net.decodex.dcp.core.supertokens.responses/-third-party-tokens-d-t-o/index.md)? = null, val clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [generateCodeChallenge](generate-code-challenge.md) | [common]<br>fun [generateCodeChallenge](generate-code-challenge.md)(verifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [generateCodeVerifier](generate-code-verifier.md) | [common]<br>fun [generateCodeVerifier](generate-code-verifier.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
