package net.decodex.dcp.core.supertokens.recipes.emailverification.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.responses.VerifyEmailResponseDTO

internal class CheckEmailVerifiedUseCase(
    private val client: HttpClient,
) {
    suspend fun checkEmailVerified(): Boolean {
        val response = client.get(SuperTokensRoutes.EmailVerification.CHECK_VERIFIED)

        val body = response.body<VerifyEmailResponseDTO>()

        return body.isVerified == true
    }
}
