package net.decodex.dcp.core.supertokens.recipes.thirdparty

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.handlers.SignInProvider
import net.decodex.dcp.core.supertokens.handlers.SignInProviderConfig
import net.decodex.dcp.core.supertokens.models.SignInData

abstract class ThirdPartySignIn<C : SignInProviderConfig> : SignInProvider<C, SignInData> {
    internal abstract val providerId: String
}

abstract class ThirdPartySignInAuthCode(
    override val providerId: String,
) : ThirdPartySignIn<ThirdPartySignInAuthCode.Config>() {
    data class Config(
        var redirectURIQueryParams: Map<String, String>? = null,
        var clientType: String? = null,
    ) : SignInProviderConfig

    override suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: Config.() -> Unit,
    ): SignInData {
        val config = Config().apply(configure)
        val provider = superTokensClient.getRecipe<ThirdPartyRecipe>().getProviderById(providerId)

        return superTokensClient.getRecipe<ThirdPartyRecipe>().thirdPartyAuthCodeSignIn(
            providerId = providerId,
            redirectURI =
                checkNotNull(provider.config.redirectUri) {
                    "The provider needs to have a redirectUri configured"
                },
            redirectURIQueryParams = config.redirectURIQueryParams ?: emptyMap(),
            clientType = config.clientType,
        )
    }
}

abstract class ThirdPartySignInTokens(
    override val providerId: String,
) : ThirdPartySignIn<ThirdPartySignInTokens.Config>() {
    data class Config(
        var accessToken: String? = null,
        var idToken: String? = null,
        var clientType: String? = null,
    ) : SignInProviderConfig

    override suspend fun signIn(
        superTokensClient: SuperTokensClient,
        configure: Config.() -> Unit,
    ): SignInData {
        val config = Config().apply(configure)

        return superTokensClient.getRecipe<ThirdPartyRecipe>().thirdPartyTokenSignIn(
            providerId = providerId,
            accessToken = requireNotNull(config.accessToken) { "accessToken is required" },
            idToken = config.idToken,
            clientType = config.clientType,
        )
    }
}
