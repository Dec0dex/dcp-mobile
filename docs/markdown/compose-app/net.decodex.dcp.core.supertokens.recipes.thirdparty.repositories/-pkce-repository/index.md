//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.thirdparty.repositories](../index.md)/[PkceRepository](index.md)

# PkceRepository

interface [PkceRepository](index.md)

#### Inheritors

| |
|---|
| [PkceRepositoryImpl](../-pkce-repository-impl/index.md) |

## Functions

| Name | Summary |
|---|---|
| [generatePkceCodeVerifier](generate-pkce-code-verifier.md) | [common]<br>abstract suspend fun [generatePkceCodeVerifier](generate-pkce-code-verifier.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getPkceCodeChallenge](get-pkce-code-challenge.md) | [common]<br>abstract suspend fun [getPkceCodeChallenge](get-pkce-code-challenge.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getPkceCodeVerifier](get-pkce-code-verifier.md) | [common]<br>abstract suspend fun [getPkceCodeVerifier](get-pkce-code-verifier.md)(providerId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
