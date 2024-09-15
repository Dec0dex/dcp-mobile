package net.decodex.dcp.core.supertokens.recipes.session.usecases

import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

internal class UpdateAccessTokenUseCase(
    private val sessionRecipe: SessionRecipe,
) {
    suspend fun updateAccessToken(token: String) {
        sessionRecipe.tokensRepository.setAccessToken(token)
        sessionRecipe.claimsRepository.setClaimsFromJwt(token)
        sessionRecipe.clearClientTokens()

        sessionRecipe.claimsRepository.getUserId()?.let {
            sessionRecipe.authRepository.setAuthenticated(
                userId = it,
                multiFactorVerified = sessionRecipe.claimsRepository.isMultiFactorVerified(),
            )
        }
    }
}
