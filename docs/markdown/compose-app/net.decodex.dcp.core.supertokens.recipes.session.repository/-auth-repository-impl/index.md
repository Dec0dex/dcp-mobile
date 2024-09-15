//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[AuthRepositoryImpl](index.md)

# AuthRepositoryImpl

[common]\
class [AuthRepositoryImpl](index.md) : [AuthRepository](../-auth-repository/index.md)

## Constructors

| | |
|---|---|
| [AuthRepositoryImpl](-auth-repository-impl.md) | [common]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [authState](auth-state.md) | [common]<br>open override val [authState](auth-state.md): StateFlow&lt;[AuthState](../-auth-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [setAuthenticated](set-authenticated.md) | [common]<br>open override fun [setAuthenticated](set-authenticated.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), multiFactorVerified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setLoggedIn](set-logged-in.md) | [common]<br>open override fun [setLoggedIn](set-logged-in.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setUnauthenticated](set-unauthenticated.md) | [common]<br>open override fun [setUnauthenticated](set-unauthenticated.md)() |
