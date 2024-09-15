package net.decodex.dcp.core.supertokens.recipes.session

import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import io.ktor.http.fullPath
import net.decodex.dcp.core.supertokens.common.COOKIE_ACCESS_TOKEN
import net.decodex.dcp.core.supertokens.common.COOKIE_REFRESH_TOKEN
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes

internal fun defaultCookieStorage(
    sessionRecipe: SessionRecipe,
) = object : CookiesStorage {
    override suspend fun addCookie(
        requestUrl: Url,
        cookie: Cookie,
    ) {
        when (cookie.name) {
            COOKIE_ACCESS_TOKEN -> {
                val token = cookie.value
                if (token.isNotBlank()) {
                    sessionRecipe.updateAccessTokenUseCase.updateAccessToken(token)
                }
            }

            COOKIE_REFRESH_TOKEN -> {
                val token = cookie.value
                if (token.isBlank() && !requestUrl.fullPath.endsWith(SuperTokensRoutes.Session.SIGN_OUT)) {
                    sessionRecipe.signOut(clearServerSession = false)
                } else {
                    sessionRecipe.updateRefreshTokenUseCase.updateRefreshToken(token)
                }
            }
        }
    }

    override suspend fun get(requestUrl: Url): List<Cookie> =
        buildList {
            sessionRecipe.tokensRepository.getAccessToken()?.let {
                add(Cookie(COOKIE_ACCESS_TOKEN, it))
            }
            if (requestUrl.fullPath.endsWith(SuperTokensRoutes.Session.REFRESH)) {
                sessionRecipe.tokensRepository.getRefreshToken()?.let {
                    add(Cookie(COOKIE_REFRESH_TOKEN, it))
                }
            }
        }

    override fun close() = Unit
}
