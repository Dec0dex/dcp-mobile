package net.decodex.dcp.core.supertokens.recipes.session.usecases

import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.RefreshTokensParams
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.HttpStatusCode
import io.ktor.http.setCookie
import net.decodex.dcp.core.supertokens.common.COOKIE_ACCESS_TOKEN
import net.decodex.dcp.core.supertokens.common.COOKIE_REFRESH_TOKEN
import net.decodex.dcp.core.supertokens.common.HEADER_ACCESS_TOKEN
import net.decodex.dcp.core.supertokens.common.HEADER_REFRESH_TOKEN
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

internal class RefreshTokensUseCase(
    private val sessionRecipe: SessionRecipe,
) {
    suspend fun refreshTokens(client: HttpClient): BearerTokens? {
        return sessionRecipe.tokensRepository.getRefreshToken()?.let { refreshTokens(client, it) }
    }

    suspend fun refreshTokens(params: RefreshTokensParams): BearerTokens? {
        return (
            params.oldTokens?.refreshToken
                ?: sessionRecipe.tokensRepository.getRefreshToken()
        )?.let {
            refreshTokens(params.client, it)
        }
    }

    private suspend fun refreshTokens(
        client: HttpClient,
        refreshToken: String,
    ): BearerTokens? {
        val response =
            client.post(SuperTokensRoutes.Session.REFRESH) {
                header(HEADER_REFRESH_TOKEN, refreshToken)
                attributes.put(Auth.AuthCircuitBreaker, Unit)
            }

        if (response.status != HttpStatusCode.OK) {
            if (response.status == HttpStatusCode.Unauthorized) {
                sessionRecipe.signOut()
            }

            return null
        }

        val cookies = response.setCookie()

        val newRefreshToken =
            response.headers[HEADER_REFRESH_TOKEN]
                ?: cookies.firstOrNull { it.name == COOKIE_REFRESH_TOKEN }?.value ?: return null
        val newAccessToken =
            response.headers[HEADER_ACCESS_TOKEN]
                ?: cookies.firstOrNull { it.name == COOKIE_ACCESS_TOKEN }?.value ?: return null

        sessionRecipe.updateAccessTokenUseCase.updateAccessToken(newAccessToken)
        sessionRecipe.updateRefreshTokenUseCase.updateRefreshToken(newRefreshToken)

        return BearerTokens(newAccessToken, newRefreshToken)
    }
}
