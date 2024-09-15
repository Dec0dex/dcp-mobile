package net.decodex.dcp.core.supertokens.recipes.multifactor

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.Recipe
import net.decodex.dcp.core.supertokens.recipes.RecipeBuilder
import net.decodex.dcp.core.supertokens.recipes.RecipeConfig
import net.decodex.dcp.core.supertokens.recipes.multifactor.usecases.CheckMultiFactorStatusUseCase

class MultiFactorAuthConfig : RecipeConfig

class MultiFactorAuthRecipe(
    private val superTokens: SuperTokensClient,
    private val config: MultiFactorAuthConfig,
) : Recipe<MultiFactorAuthConfig> {
    private val checkMultiFactorStatusUseCase by lazy {
        CheckMultiFactorStatusUseCase(client = superTokens.apiClient)
    }

    suspend fun checkMfaStatus() = checkMultiFactorStatusUseCase.checkStatus()
}

object MultiFactorAuth : RecipeBuilder<MultiFactorAuthConfig, MultiFactorAuthRecipe>() {
    override fun install(
        configure: MultiFactorAuthConfig.() -> Unit,
    ): (SuperTokensClient) -> MultiFactorAuthRecipe {
        val config = MultiFactorAuthConfig().apply(configure)

        return { MultiFactorAuthRecipe(it, config) }
    }
}
