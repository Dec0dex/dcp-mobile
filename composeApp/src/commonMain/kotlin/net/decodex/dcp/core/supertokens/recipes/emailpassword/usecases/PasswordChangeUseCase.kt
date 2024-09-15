package net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_NEW_PASSWORD_ID
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_PASSWORD_ID
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.requests.FormFieldDTO
import net.decodex.dcp.core.supertokens.requests.PasswordChangeRequestDTO
import net.decodex.dcp.core.supertokens.responses.StatusResponseDTO

internal class PasswordChangeUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
) {
    suspend fun changePassword(
        currentPassword: String,
        newPassword: String,
    ) {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.EmailPassword.PASSWORD_CHANGE),
                    )
                }
                setBody(
                    PasswordChangeRequestDTO(
                        formFields =
                            listOf(
                                FormFieldDTO(id = FORM_FIELD_PASSWORD_ID, value = currentPassword),
                                FormFieldDTO(id = FORM_FIELD_NEW_PASSWORD_ID, value = newPassword),
                            ),
                    ),
                )
            }

        val body = response.body<StatusResponseDTO>()

        if (body.status != SuperTokensStatus.OK.value) {
            throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
