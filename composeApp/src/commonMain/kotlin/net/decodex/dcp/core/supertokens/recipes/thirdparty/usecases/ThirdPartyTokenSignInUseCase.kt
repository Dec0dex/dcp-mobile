package net.decodex.dcp.core.supertokens.recipes.thirdparty.usecases

import ThirdPartySignInUpRequestDTO
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
import net.decodex.dcp.core.supertokens.responses.SignInUpResponseDTO
import net.decodex.dcp.core.supertokens.responses.ThirdPartyTokensDTO

internal class ThirdPartyTokenSignInUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
    private val userRepository: SuperTokensUserRepository,
) {
    suspend fun signIn(
        providerId: String,
        accessToken: String,
        idToken: String?,
        clientType: String? = null,
    ): SignInData {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.ThirdParty.SIGN_IN_UP),
                    )
                }
                setBody(
                    ThirdPartySignInUpRequestDTO(
                        oAuthTokens =
                            ThirdPartyTokensDTO(
                                accessToken = accessToken,
                                idToken = idToken,
                            ),
                        thirdPartyId = providerId,
                        clientType = clientType,
                    ),
                )
            }

        val body = response.body<SignInUpResponseDTO>()

        return when (val status = body.status.toStatus()) {
            SuperTokensStatus.OK -> {
                SignInData(
                    user = checkNotNull(body.user),
                    createdNewUser = checkNotNull(body.createdNewUser),
                ).also { userRepository.updateUser(it.user) }
            }

            else -> throw SuperTokensStatusException(status)
        }
    }
}
