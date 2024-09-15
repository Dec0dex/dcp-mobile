package net.decodex.dcp.core.supertokens.recipes.emailpassword.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_EMAIL_ID
import net.decodex.dcp.core.supertokens.common.FORM_FIELD_PASSWORD_ID
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.models.SuperTokensUser
import net.decodex.dcp.core.supertokens.recipes.core.repositories.SuperTokensUserRepository
import net.decodex.dcp.core.supertokens.requests.FormFieldDTO
import net.decodex.dcp.core.supertokens.requests.FormFieldRequestDTO
import net.decodex.dcp.core.supertokens.responses.SignInResponseDTO

internal class EmailPasswordSignInUseCase(
    private val client: HttpClient,
    private val userRepository: SuperTokensUserRepository,
    private val tenantId: String?,
) {
    suspend fun signIn(
        email: String,
        password: String,
    ): SuperTokensUser {
        println(password)
        try {
            val result = client.get("https://httpbin.org/delay/10") // This URL delays the response by 10 seconds
            println(result)
        } catch (e: Exception) {
            println("Request timed out or failed: ${e.message}")
        }
        val response =
            client.post {
                url {
                    val urlPath = listOfNotNull(tenantId, SuperTokensRoutes.EmailPassword.SIGN_IN)
                    appendEncodedPathSegments(urlPath)
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

            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
