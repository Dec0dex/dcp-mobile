package net.decodex.dcp.core.supertokens.recipes

import io.ktor.client.HttpClientConfig
import net.decodex.dcp.core.supertokens.SuperTokensClient

interface RecipeConfig

interface Recipe<C : RecipeConfig> {
    suspend fun postInit() {}

    fun HttpClientConfig<*>.configureClient() {}
}

typealias BuildRecipe = (SuperTokensClient) -> Recipe<*>

abstract class RecipeBuilder<C : RecipeConfig, R : Recipe<C>> {
    abstract fun install(configure: C.() -> Unit): BuildRecipe
}
