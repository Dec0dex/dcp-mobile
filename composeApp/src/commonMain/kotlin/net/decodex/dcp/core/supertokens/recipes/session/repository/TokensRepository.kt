package net.decodex.dcp.core.supertokens.recipes.session.repository

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

abstract class TokensRepository {
    abstract suspend fun getAccessToken(): String?

    abstract suspend fun setAccessToken(accessToken: String?)

    abstract suspend fun getRefreshToken(): String?

    abstract suspend fun setRefreshToken(refreshToken: String?)
}

suspend fun SuperTokensClient.getAccessToken(): String? {
    return getRecipe<SessionRecipe>().tokensRepository.getAccessToken()
}

suspend fun SuperTokensClient.getRefreshToken(): String? {
    return getRecipe<SessionRecipe>().tokensRepository.getRefreshToken()
}
