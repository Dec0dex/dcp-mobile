package net.decodex.dcp.core.supertokens.recipes.passwordless.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.HEADER_RECIPE_ID
import net.decodex.dcp.core.supertokens.common.RECIPE_PASSWORDLESS
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.responses.ExistsResponseDTO

internal class CheckPhoneNumberExistsUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
) {
    suspend fun checkPhoneNumberExists(phoneNumber: String): Boolean {
        val response =
            client.get {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.PHONE_NUMBER_EXISTS),
                    )
                    parameters.append("phoneNumber", phoneNumber)
                }
                header(HEADER_RECIPE_ID, RECIPE_PASSWORDLESS)
            }

        val body = response.body<ExistsResponseDTO>()

        return when (body.status) {
            SuperTokensStatus.OK.value -> body.exists
            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
