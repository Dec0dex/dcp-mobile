package net.decodex.dcp.core.supertokens.recipes.emailverification.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.responses.StatusResponseDTO

internal class SendEmailVerificationUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
) {
    suspend fun sendVerificationEmail(): Boolean {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.EmailVerification.VERIFY_TOKEN),
                    )
                }
            }

        val body = response.body<StatusResponseDTO>()

        return body.status.toStatus() == SuperTokensStatus.OK
    }
}
