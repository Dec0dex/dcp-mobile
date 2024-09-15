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
class ProviderGitLab(superTokens: SuperTokensClient, config: ProviderConfig) :
    Provider<ProviderConfig>(id = ThirdPartyAuth.GITLAB, config = config)

object GitLab : ProviderBuilder<ProviderConfig, ProviderGitLab>() {
    const val ID = ThirdPartyAuth.GITLAB

    object AuthCode : ThirdPartySignInAuthCode(ID)

    object Tokens : ThirdPartySignInTokens(ID)

    override fun install(
        configure: ProviderConfig.() -> Unit,
    ): (SuperTokensClient, ThirdPartyRecipe) -> ProviderGitLab {
        val config = ProviderConfig().apply(configure)

        return { superTokens, _ ->
            ProviderGitLab(superTokens, config)
        }
    }
}
