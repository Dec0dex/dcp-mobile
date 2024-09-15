package net.decodex.dcp.core.supertokens.handlers

import net.decodex.dcp.core.supertokens.SuperTokensClient

interface SignInProviderConfig

interface SignInProvider<C : SignInProviderConfig, R> {
    suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: (C.() -> Unit),
    ): R
}

suspend fun <C, Provider : SignInProvider<C, R>, R> SuperTokensClient.signInWith(
    provider: Provider,
    config: (C.() -> Unit),
): R {
    return provider.signIn(this, config)
}
