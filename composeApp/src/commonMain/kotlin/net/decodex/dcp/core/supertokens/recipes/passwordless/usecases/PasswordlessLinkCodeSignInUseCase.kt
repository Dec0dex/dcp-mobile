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
import net.decodex.dcp.core.supertokens.models.SignInData
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepository
import net.decodex.dcp.core.supertokens.requests.ConsumePasswordlessCodeRequestDTO
import net.decodex.dcp.core.supertokens.responses.SignInUpResponseDTO

internal class PasswordlessLinkCodeSignInUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
    private val userRepository: SuperTokensUserRepository,
) {
    suspend fun signIn(
        preAuthSessionId: String,
        linkCode: String,
    ): SignInData {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.Passwordless.SIGNUP_CODE_CONSUME),
                    )
                }
                setBody(
                    ConsumePasswordlessCodeRequestDTO(
                        preAuthSessionId = preAuthSessionId,
                        linkCode = linkCode,
                    ),
                )
            }

        val body = response.body<SignInUpResponseDTO>()

        return when (val status = body.status.toStatus()) {
            SuperTokensStatus.OK -> {
                SignInData(
                    user = checkNotNull(body.user),
                    createdNewUser = checkNotNull(body.createdNewUser),
                ).also {
                    userRepository.updateUser(it.user)
                }
            }

            else -> throw SuperTokensStatusException(status)
        }
    }
}
