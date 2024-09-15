package net.decodex.dcp.core.supertokens.recipes.totp.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.requests.VerifyTotpRequestDTO
import net.decodex.dcp.core.supertokens.responses.VerifyTotpResponseDTO

data class InvalidTotpException(
    val currentNumberOfFailedAttempts: Long,
    val maxNumberOfFailedAttempts: Long,
) : SuperTokensStatusException(SuperTokensStatus.InvalidTotpCodeError)

data class InvalidTotpLimitException(
    val retryAfterMs: Long,
) : SuperTokensStatusException(SuperTokensStatus.InvalidTotpCodeError)

internal class VerifyTotpUseCase(
    private val client: HttpClient,
) {
    suspend fun verifyCode(totp: String): Boolean {
        val response =
            client.post(SuperTokensRoutes.Totp.VERIFY) {
                setBody(VerifyTotpRequestDTO(totp = totp))
            }

        val body = response.body<VerifyTotpResponseDTO>()

        return when (body.status.toStatus()) {
            SuperTokensStatus.OK -> true
            SuperTokensStatus.InvalidTotpCodeError -> throw InvalidTotpException(
                currentNumberOfFailedAttempts = checkNotNull(body.currentNumberOfFailedAttempts),
                maxNumberOfFailedAttempts = checkNotNull(body.maxNumberOfFailedAttempts),
            )

            SuperTokensStatus.TotpLimitReachedError -> throw InvalidTotpLimitException(
                retryAfterMs = checkNotNull(body.retryAfterMs),
            )

            else -> false
        }
    }
}
