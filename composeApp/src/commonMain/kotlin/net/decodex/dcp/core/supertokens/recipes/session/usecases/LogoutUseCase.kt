package net.decodex.dcp.core.supertokens.recipes.session.usecases

import io.ktor.client.request.post
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepository
import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

internal class LogoutUseCase(
    private val sessionRecipe: SessionRecipe,
    private val userRepository: SuperTokensUserRepository,
) {
    suspend fun signOut(clearServerSession: Boolean = true) {
        if (clearServerSession) {
            with(sessionRecipe.superTokens.apiClient) { runCatching { post(SuperTokensRoutes.Session.SIGN_OUT) } }
        }

        sessionRecipe.tokensRepository.setAccessToken(null)
        sessionRecipe.tokensRepository.setRefreshToken(null)
        sessionRecipe.clearClientTokens()
        sessionRecipe.claimsRepository.clear()
        sessionRecipe.authRepository.setUnauthenticated()
        userRepository.updateUser(null)
    }
}
