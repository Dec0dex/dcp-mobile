package net.decodex.dcp.core.supertokens.recipes.passwordless.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.recipes.passwordless.PasswordlessSignUpData
import net.decodex.dcp.core.supertokens.requests.StartPasswordlessSignInUpRequestDTO
import net.decodex.dcp.core.supertokens.responses.StartPasswordlessSignInUpResponseDTO

internal class PasswordlessPhoneNumberSignUpUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
) {
    suspend fun signUp(phoneNumber: String): PasswordlessSignUpData {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.Passwordless.SIGNUP_CODE),
                    )
                }
                setBody(StartPasswordlessSignInUpRequestDTO(phoneNumber = phoneNumber))
            }

        val body = response.body<StartPasswordlessSignInUpResponseDTO>()

        return when (val status = body.status.toStatus()) {
            SuperTokensStatus.OK -> {
                PasswordlessSignUpData(
                    deviceId = checkNotNull(body.deviceId),
                    preAuthSessionId = checkNotNull(body.preAuthSessionId),
                    flowType = checkNotNull(body.flowType),
                )
            }

            else -> throw SuperTokensStatusException(status)
        }
    }
}
