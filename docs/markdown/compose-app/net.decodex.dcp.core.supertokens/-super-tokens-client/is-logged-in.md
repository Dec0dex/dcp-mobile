//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens](../index.md)/[SuperTokensClient](index.md)/[isLoggedIn](is-logged-in.md)

# isLoggedIn

[common]\
fun [isLoggedIn](is-logged-in.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

true, if the the user is at least logged in (but may not be authenticated from the backend yet) It essentially means, there is a refresh token present, but no access token yet, e.g. during startup when a new access token hasn't been fetched yet.
