//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.session.repository](../index.md)/[AuthState](index.md)

# AuthState

sealed class [AuthState](index.md)

#### Inheritors

| |
|---|
| [Unauthenticated](-unauthenticated/index.md) |
| [LoggedIn](-logged-in/index.md) |
| [Authenticated](-authenticated/index.md) |

## Types

| Name | Summary |
|---|---|
| [Authenticated](-authenticated/index.md) | [common]<br>data class [Authenticated](-authenticated/index.md)(val userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val multiFactorVerified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [AuthState](index.md) |
| [LoggedIn](-logged-in/index.md) | [common]<br>data class [LoggedIn](-logged-in/index.md)(val userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AuthState](index.md) |
| [Unauthenticated](-unauthenticated/index.md) | [common]<br>data object [Unauthenticated](-unauthenticated/index.md) : [AuthState](index.md) |

## Properties

| Name | Summary |
|---|---|
| [isLoggedIn](is-logged-in.md) | [common]<br>val [isLoggedIn](is-logged-in.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
