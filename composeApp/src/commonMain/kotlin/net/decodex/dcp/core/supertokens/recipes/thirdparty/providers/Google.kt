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
class ProviderGoogle(superTokens: SuperTokensClient, config: ProviderConfig) :
    Provider<ProviderConfig>(id = ThirdPartyAuth.GOOGLE, config = config)

object Google : ProviderBuilder<ProviderConfig, ProviderGoogle>() {
    const val ID = ThirdPartyAuth.GOOGLE

    object AuthCode : ThirdPartySignInAuthCode(ID)

    object Tokens : ThirdPartySignInTokens(ID)

    override fun install(
        configure: ProviderConfig.() -> Unit,
    ): (SuperTokensClient, ThirdPartyRecipe) -> ProviderGoogle {
        val config = ProviderConfig().apply(configure)

        return { superTokens, _ ->
            ProviderGoogle(superTokens, config)
        }
    }
}
