package net.decodex.dcp.core.supertokens.handlers

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.responses.FormFieldErrorDTO

interface SignUpProviderConfig

interface SignUpProvider<C : SignUpProviderConfig, R> {
    suspend fun signUp(
        superTokensClient: SuperTokensClient,
        configure: (C.() -> Unit),
    ): R
}

suspend fun <C, Provider : SignUpProvider<C, R>, R> SuperTokensClient.signUpWith(
    provider: Provider,
    config: (C.() -> Unit),
): R {
    return provider.signUp(this, config)
}

class FormFieldException(val errors: List<FormFieldErrorDTO>) :
    SuperTokensStatusException(SuperTokensStatus.FormFieldError)
