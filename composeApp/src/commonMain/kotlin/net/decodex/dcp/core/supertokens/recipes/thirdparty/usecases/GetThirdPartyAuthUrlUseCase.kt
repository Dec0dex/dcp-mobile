package net.decodex.dcp.core.supertokens.recipes.thirdparty.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendEncodedPathSegments
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.recipes.thirdparty.Provider
import net.decodex.dcp.core.supertokens.responses.AuthorizationUrlResponseDTO

internal class GetThirdPartyAuthUrlUseCase(
    private val client: HttpClient,
    private val tenantId: String?,
) {
    suspend fun getAuthUrl(
        provider: Provider<*>,
        clientType: String? = null,
    ): String {
        val response =
            client.get {
                url {
                    appendEncodedPathSegments(
                        listOfNotNull(tenantId, SuperTokensRoutes.ThirdParty.AUTH_URL),
                    )
                    parameters.append("thirdPartyId", provider.id)
                    parameters.append(
                        "redirectURIOnProviderDashboard",
                        checkNotNull(provider.config.redirectUri),
                    )
                    clientType?.let {
                        parameters.append("clientType", it)
                    }
                }
            }

        val body = response.body<AuthorizationUrlResponseDTO>()

        return when (body.status) {
            SuperTokensStatus.OK.value -> checkNotNull(body.urlWithQueryParams)
            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
