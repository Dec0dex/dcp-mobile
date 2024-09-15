//[composeApp](../../../index.md)/[[root]](../index.md)/[ThirdPartySignInUpRequestDTO](index.md)

# ThirdPartySignInUpRequestDTO

[common]\
@Serializable

data class [ThirdPartySignInUpRequestDTO](index.md)(val thirdPartyId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val redirectURIInfo: [RedirectUriInfoDTO](../-redirect-uri-info-d-t-o/index.md)? = null, val oAuthTokens: [ThirdPartyTokensDTO](../../net.decodex.dcp.core.supertokens.responses/-third-party-tokens-d-t-o/index.md)? = null, val clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

## Constructors

| | |
|---|---|
| [ThirdPartySignInUpRequestDTO](-third-party-sign-in-up-request-d-t-o.md) | [common]<br>constructor(thirdPartyId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), redirectURIInfo: [RedirectUriInfoDTO](../-redirect-uri-info-d-t-o/index.md)? = null, oAuthTokens: [ThirdPartyTokensDTO](../../net.decodex.dcp.core.supertokens.responses/-third-party-tokens-d-t-o/index.md)? = null, clientType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [clientType](client-type.md) | [common]<br>val [clientType](client-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [oAuthTokens](o-auth-tokens.md) | [common]<br>val [oAuthTokens](o-auth-tokens.md): [ThirdPartyTokensDTO](../../net.decodex.dcp.core.supertokens.responses/-third-party-tokens-d-t-o/index.md)? = null |
| [redirectURIInfo](redirect-u-r-i-info.md) | [common]<br>val [redirectURIInfo](redirect-u-r-i-info.md): [RedirectUriInfoDTO](../-redirect-uri-info-d-t-o/index.md)? = null |
| [thirdPartyId](third-party-id.md) | [common]<br>val [thirdPartyId](third-party-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
