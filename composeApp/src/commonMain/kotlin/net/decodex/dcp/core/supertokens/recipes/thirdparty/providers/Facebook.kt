package net.decodex.dcp.core.supertokens.recipes.thirdparty.providers

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.ThirdPartyAuth
import net.decodex.dcp.core.supertokens.recipes.thirdparty.Provider
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ProviderBuilder
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ProviderConfig
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ThirdPartyRecipe
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ThirdPartySignInAuthCode
import net.decodex.dcp.core.supertokens.recipes.thirdparty.ThirdPartySignInTokens

@Suppress("UNUSED_PARAMETER")
class ProviderFacebook(superTokens: SuperTokensClient, config: ProviderConfig) :
    Provider<ProviderConfig>(id = ThirdPartyAuth.FACEBOOK, config = config)

object Facebook : ProviderBuilder<ProviderConfig, ProviderFacebook>() {
    const val ID = ThirdPartyAuth.FACEBOOK

    object AuthCode : ThirdPartySignInAuthCode(ID)

    object Tokens : ThirdPartySignInTokens(ID)

    override fun install(
        configure: ProviderConfig.() -> Unit,
    ): (SuperTokensClient, ThirdPartyRecipe) -> ProviderFacebook {
        val config = ProviderConfig().apply(configure)

        return { superTokens, _ ->
            ProviderFacebook(superTokens, config)
        }
    }
}
