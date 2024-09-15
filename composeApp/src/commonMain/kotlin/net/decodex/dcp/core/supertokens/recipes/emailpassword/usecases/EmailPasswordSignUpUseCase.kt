package net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_EMAIL_ID
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_PASSWORD_ID
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.handlers.FormFieldException
import net.decodex.dcp.core.supertokens.models.SuperTokensUser
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepository
import net.decodex.dcp.core.supertokens.requests.FormFieldDTO
import net.decodex.dcp.core.supertokens.requests.FormFieldRequestDTO
import net.decodex.dcp.core.supertokens.responses.SignInResponseDTO

internal class EmailPasswordSignUpUseCase(
    private val client: HttpClient,
    private val userRepository: SuperTokensUserRepository,
    private val tenantId: String?,
) {
    suspend fun signUp(
        email: String,
        password: String,
    ): SuperTokensUser {
        val response =
            client.post {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.EmailPassword.SIGN_UP),
                    )
                }
                setBody(
                    FormFieldRequestDTO(
                        formFields =
                            listOf(
                                FormFieldDTO(id = FORM_FIELD_EMAIL_ID, value = email),
                                FormFieldDTO(id = FORM_FIELD_PASSWORD_ID, value = password),
                            ),
                    ),
                )
            }

        val body = response.body<SignInResponseDTO>()

        return when (body.status) {
            SuperTokensStatus.OK.value ->
                checkNotNull(body.user).also {
                    userRepository.updateUser(it)
                }

            SuperTokensStatus.FormFieldError.value -> throw FormFieldException(
                errors = checkNotNull(body.formFields),
            )

            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
