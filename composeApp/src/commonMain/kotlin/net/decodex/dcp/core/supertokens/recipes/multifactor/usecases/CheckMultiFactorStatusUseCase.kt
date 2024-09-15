package net.decodex.dcp.core.supertokens.recipes.multifactor.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.models.EmailsStatus
import net.decodex.dcp.core.supertokens.models.FactorsStatus
import net.decodex.dcp.core.supertokens.models.MultiFactorAuthStatus
import net.decodex.dcp.core.supertokens.models.PhoneStatus
import net.decodex.dcp.core.supertokens.responses.MultiFactorStatusResponseDTO

internal class CheckMultiFactorStatusUseCase(
    private val client: HttpClient,
) {
    suspend fun checkStatus(): MultiFactorAuthStatus {
        val response = client.post(SuperTokensRoutes.Mfa.CHECK)
        val body = response.body<MultiFactorStatusResponseDTO>()

        return when (body.status) {
            SuperTokensStatus.OK.value ->
                MultiFactorAuthStatus(
                    factors =
                        FactorsStatus(
                            alreadySetup = checkNotNull(body.factors).alreadySetup,
                            allowedToSetup = checkNotNull(body.factors).allowedToSetup,
                            next = checkNotNull(body.factors).next,
                        ),
                    emails = EmailsStatus(),
                    phoneNumbers = PhoneStatus(),
                )

            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
