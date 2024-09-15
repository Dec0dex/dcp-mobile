//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[AuthRepository](index.md)

# AuthRepository

interface [AuthRepository](index.md)

#### Inheritors

| |
|---|
| [AuthRepositoryImpl](../-auth-repository-impl/index.md) |

## Properties

| Name | Summary |
|---|---|
| [authState](auth-state.md) | [common]<br>abstract val [authState](auth-state.md): StateFlow&lt;[AuthState](../-auth-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [setAuthenticated](set-authenticated.md) | [common]<br>abstract fun [setAuthenticated](set-authenticated.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), multiFactorVerified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [setLoggedIn](set-logged-in.md) | [common]<br>abstract fun [setLoggedIn](set-logged-in.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setUnauthenticated](set-unauthenticated.md) | [common]<br>abstract fun [setUnauthenticated](set-unauthenticated.md)() |
