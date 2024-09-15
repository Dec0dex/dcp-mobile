package net.decodex.dcp.core.supertokens.recipes.passwordless

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.RECIPE_PASSWORDLESS
import net.decodex.dcp.core.supertokens.handlers.SignInProvider
import net.decodex.dcp.core.supertokens.handlers.SignInProviderConfig
import net.decodex.dcp.core.supertokens.handlers.SignUpProvider
import net.decodex.dcp.core.supertokens.handlers.SignUpProviderConfig
import net.decodex.dcp.core.supertokens.models.PasswordlessMode
import net.decodex.dcp.core.supertokens.models.SignInData
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.core.usecases.CheckEmailExistsUseCase
import net.decodex.dcp.core.supertokens.recipes.passwordless.usecases.CheckPhoneNumberExistsUseCase
import net.decodex.dcp.core.supertokens.recipes.passwordless.usecases.PasswordlessEmailSignUpUseCase
import net.decodex.dcp.core.supertokens.recipes.passwordless.usecases.PasswordlessInputCodeSignInUseCase
import net.decodex.dcp.core.supertokens.recipes.passwordless.usecases.PasswordlessLinkCodeSignInUseCase
import net.decodex.dcp.core.supertokens.recipes.passwordless.usecases.PasswordlessPhoneNumberSignUpUseCase

class PasswordlessConfig : RecipeConfig

class PasswordlessRecipe(
    private val superTokens: SuperTokensClient,
    @Suppress("unused") private val config: PasswordlessConfig,
) : Recipe<PasswordlessConfig> {
    private val passwordlessEmailSignUpUseCase by lazy {
        PasswordlessEmailSignUpUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    private val passwordlessPhoneNumberSignUpUseCase by lazy {
        PasswordlessPhoneNumberSignUpUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    private val passwordlessLinkCodeSignInUseCase by lazy {
        PasswordlessLinkCodeSignInUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            userRepository = superTokens.userRepository,
        )
    }

    private val passwordlessInputCodeSignInUseCase by lazy {
        PasswordlessInputCodeSignInUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            userRepository = superTokens.userRepository,
        )
    }

    private val checkEmailExistsUseCase by lazy {
        CheckEmailExistsUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
            recipeId = RECIPE_PASSWORDLESS,
        )
    }

    private val checkPhoneNumberExistsUseCase by lazy {
        CheckPhoneNumberExistsUseCase(
            client = superTokens.apiClient,
            tenantId = superTokens.tenantId,
        )
    }

    suspend fun signUpEmail(email: String) = passwordlessEmailSignUpUseCase.signUp(email)

    suspend fun signUpPhoneNumber(phoneNumber: String) =
        passwordlessPhoneNumberSignUpUseCase.signUp(phoneNumber)

    suspend fun signInLinkCode(
        preAuthSessionId: String,
        linkCode: String,
    ) =
        passwordlessLinkCodeSignInUseCase.signIn(
            preAuthSessionId = preAuthSessionId,
            linkCode = linkCode,
        )

    suspend fun signInInputCode(
        preAuthSessionId: String,
        deviceId: String,
        userInputCode: String,
    ) =
        passwordlessInputCodeSignInUseCase.signIn(
            preAuthSessionId = preAuthSessionId,
            deviceId = deviceId,
            userInputCode = userInputCode,
        )

    suspend fun checkEmailExists(email: String) = checkEmailExistsUseCase.checkEmailExists(email)

    suspend fun checkPhoneNumberExists(phoneNumber: String) =
        checkPhoneNumberExistsUseCase.checkPhoneNumberExists(phoneNumber)
}

data class PasswordlessSignUpData(
    val deviceId: String,
    val preAuthSessionId: String,
    val flowType: PasswordlessMode,
)

object Passwordless :
    RecipeBuilder<PasswordlessConfig, PasswordlessRecipe>(),
    SignUpProvider<Passwordless.SignUpConfig, PasswordlessSignUpData> {
    override fun install(
        configure: PasswordlessConfig.() -> Unit,
    ): (SuperTokensClient) -> PasswordlessRecipe {
        val config = PasswordlessConfig().apply(configure)

        return { PasswordlessRecipe(it, config) }
    }

    data class SignUpConfig(var email: String? = null, var phoneNumber: String? = null) :
        SignUpProviderConfig

    override suspend fun signUp(
        superTokensClient: SuperTokensClient,
        configure: SignUpConfig.() -> Unit,
    ): PasswordlessSignUpData {
        val config = SignUpConfig().apply(configure)

        return config.email?.let {
            superTokensClient.getRecipe<PasswordlessRecipe>().signUpEmail(it)
        } ?: config.phoneNumber?.let {
            superTokensClient.getRecipe<PasswordlessRecipe>().signUpPhoneNumber(it)
        } ?: throw IllegalStateException("Either 'email' or 'phoneNumber' must be provided")
    }
}

object PasswordlessLinkCode : SignInProvider<PasswordlessLinkCode.SignInConfig, SignInData> {
    data class SignInConfig(
        var preAuthSessionId: String? = null,
        var linkCode: String? = null,
    ) : SignInProviderConfig

    override suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: SignInConfig.() -> Unit,
    ): SignInData {
        val config = SignInConfig().apply(configure)

        return superTokensClient.getRecipe<PasswordlessRecipe>().signInLinkCode(
            preAuthSessionId = checkNotNull(config.preAuthSessionId) { "preAuthSessionId is required" },
            linkCode = checkNotNull(config.linkCode) { "linkCode is required" },
        )
    }
}

object PasswordlessInputCode : SignInProvider<PasswordlessInputCode.SignInConfig, SignInData> {
    data class SignInConfig(
        var preAuthSessionId: String? = null,
        var deviceId: String? = null,
        var userInputCode: String? = null,
    ) : SignInProviderConfig

    override suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: SignInConfig.() -> Unit,
    ): SignInData {
        val config = SignInConfig().apply(configure)

        return superTokensClient.getRecipe<PasswordlessRecipe>().signInInputCode(
            preAuthSessionId = checkNotNull(config.preAuthSessionId) { "preAuthSessionId is required" },
            deviceId = checkNotNull(config.deviceId) { "deviceId is required" },
            userInputCode = checkNotNull(config.userInputCode) { "userInputCode is required" },
        )
    }
}

suspend fun SuperTokensClient.checkPhoneNumberExists(phoneNumber: String): Boolean {
    return getRecipe<PasswordlessRecipe>().checkPhoneNumberExists(phoneNumber)
}
