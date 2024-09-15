package net.decodex.dcp.core.supertokens.recipes.session.usecases

import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

internal class UpdateRefreshTokenUseCase(
    private val sessionRecipe: SessionRecipe,
) {
    suspend fun updateRefreshToken(token: String) {
        sessionRecipe.tokensRepository.setRefreshToken(token)
        sessionRecipe.clearClientTokens()
    }
}
