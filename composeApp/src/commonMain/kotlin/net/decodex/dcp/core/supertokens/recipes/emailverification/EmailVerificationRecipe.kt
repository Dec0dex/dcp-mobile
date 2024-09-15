package net.decodex.dcp.core.supertokens.recipes.emailverification

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.emailverification.usecases.CheckEmailVerifiedUseCase
import net.decodex.dcp.core.supertokens.recipes.emailverification.usecases.SendEmailVerificationUseCase
import net.decodex.dcp.core.supertokens.recipes.emailverification.usecases.VerifyEmailUseCase

class EmailVerificationConfig : RecipeConfig

class EmailVerificationRecipe(
    private val superTokens: SuperTokensClient,
    private val config: EmailVerificationConfig,
) : Recipe<EmailVerificationConfig> {
    private val sendEmailVerificationUseCase by lazy {
        SendEmailVerificationUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    private val verifyEmailUseCase by lazy {
        VerifyEmailUseCase(client = superTokens.apiClient, tenantId = superTokens.tenantId)
    }

    private val checkEmailVerifiedUseCase by lazy {
        CheckEmailVerifiedUseCase(client = superTokens.apiClient)
    }

    suspend fun sendVerificationEmail() = sendEmailVerificationUseCase.sendVerificationEmail()

    suspend fun verifyEmail(token: String) = verifyEmailUseCase.verifyEmail(token)

    suspend fun checkEmailVerified() = checkEmailVerifiedUseCase.checkEmailVerified()
}

object EmailVerification : RecipeBuilder<EmailVerificationConfig, EmailVerificationRecipe>() {
    override fun install(
        configure: EmailVerificationConfig.() -> Unit,
    ): (SuperTokensClient) -> EmailVerificationRecipe {
        val config = EmailVerificationConfig().apply(configure)

        return { EmailVerificationRecipe(it, config) }
    }
}

suspend fun SuperTokensClient.sendVerificationEmail(): Boolean {
    return getRecipe<EmailVerificationRecipe>().sendVerificationEmail()
}

suspend fun SuperTokensClient.verifyEmail(token: String): Boolean {
    return getRecipe<EmailVerificationRecipe>().verifyEmail(token)
}

suspend fun SuperTokensClient.checkEmailVerified(): Boolean {
    return getRecipe<EmailVerificationRecipe>().checkEmailVerified()
}
