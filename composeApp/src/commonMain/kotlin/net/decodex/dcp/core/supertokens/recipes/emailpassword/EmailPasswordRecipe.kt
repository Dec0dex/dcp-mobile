package net.decodex.dcp.core.supertokens.recipes.emailpassword

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.RECIPE_EMAIL_PASSWORD
import net.decodex.dcp.core.supertokens.handlers.SignInProvider
import net.decodex.dcp.core.supertokens.handlers.SignInProviderConfig
import net.decodex.dcp.core.supertokens.handlers.SignUpProvider
import net.decodex.dcp.core.supertokens.handlers.SignUpProviderConfig
import net.decodex.dcp.core.supertokens.models.SuperTokensUser
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.core.usecases.CheckEmailExistsUseCase
import net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases.EmailPasswordSignInUseCase
import net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases.EmailPasswordSignUpUseCase
import net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases.PasswordChangeUseCase
import net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases.PasswordResetUseCase
import net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases.RequestPasswordResetUseCase

class EmailPasswordConfig : RecipeConfig

class EmailPasswordRecipe(
    private val superTokens: SuperTokensClient,
    private val config: EmailPasswordConfig,
) : Recipe<EmailPasswordConfig> {
    private val emailPasswordSignInUseCase by lazy {
        EmailPasswordSignInUseCase(
            client = superTokens.apiClient,
            userRepository = superTokens.userRepository,
            tenantId = superTokens.tenantId,
        )
    }

    private val emailPasswordSignUpUseCase by lazy {
        EmailPasswordSignUpUseCase(
            client = superTokens.apiClient,
            userRepository = superTokens.userRepository,
            tenantId = superTokens.tenantId,
        )
    }

    private val checkEmailExistsUseCase by lazy {
        CheckEmailExistsUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            recipeId = RECIPE_EMAIL_PASSWORD,
        )
    }

    private val requestPasswordResetUseCase by lazy {
        RequestPasswordResetUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    private val passwordResetUseCase by lazy {
        PasswordResetUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    private val passwordChangeUseCase by lazy {
        PasswordChangeUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    suspend fun signUp(
        email: String,
        password: String,
    ) =
        emailPasswordSignUpUseCase.signUp(
            email = email,
            password = password,
        )

    suspend fun signIn(
        email: String,
        password: String,
    ) =
        emailPasswordSignInUseCase.signIn(
            email = email,
            password = password,
        )

    suspend fun checkEmailExists(email: String) =
        checkEmailExistsUseCase.checkEmailExists(email = email)

    suspend fun requestPasswordReset(email: String) =
        requestPasswordResetUseCase.requestReset(email = email)

    suspend fun resetPassword(
        token: String,
        newPassword: String,
    ) =
        passwordResetUseCase.resetPassword(
            token = token,
            newPassword = newPassword,
        )

    suspend fun changePassword(
        currentPassword: String,
        newPassword: String,
    ) =
        passwordChangeUseCase.changePassword(
            currentPassword = currentPassword,
            newPassword = newPassword,
        )
}

object EmailPassword :
    RecipeBuilder<EmailPasswordConfig, EmailPasswordRecipe>(),
    SignInProvider<EmailPassword.Config, SuperTokensUser>,
    SignUpProvider<EmailPassword.Config, SuperTokensUser> {
    override fun install(
        configure: EmailPasswordConfig.() -> Unit,
    ): (SuperTokensClient) -> EmailPasswordRecipe {
        val config = EmailPasswordConfig().apply(configure)

        return { EmailPasswordRecipe(it, config) }
    }

    data class Config(var email: String? = null, var password: String? = null) :
        SignInProviderConfig, SignUpProviderConfig

    override suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: Config.() -> Unit,
    ): SuperTokensUser {
        val config = Config().apply(configure)

        return superTokensClient.getRecipe<EmailPasswordRecipe>().signIn(
            email = checkNotNull(config.email) { "email is required" },
            password = checkNotNull(config.password) { "password is required" },
        )
    }

    override suspend fun signUp(
        superTokensClient: SuperTokensClient,
        configure: Config.() -> Unit,
    ): SuperTokensUser {
        val config = Config().apply(configure)

        return superTokensClient.getRecipe<EmailPasswordRecipe>().signUp(
            email = checkNotNull(config.email) { "email is required" },
            password = checkNotNull(config.password) { "password is required" },
        )
    }
}
