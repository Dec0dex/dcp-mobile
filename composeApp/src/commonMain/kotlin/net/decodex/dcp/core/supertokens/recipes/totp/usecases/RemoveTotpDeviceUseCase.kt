package net.decodex.dcp.core.supertokens.recipes.totp.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.requests.TotpDeviceRequestDTO
import net.decodex.dcp.core.supertokens.responses.RemoveTotpDeviceResponseDTO

internal class RemoveTotpDeviceUseCase(
    private val client: HttpClient,
) {
    suspend fun removeDevice(name: String): Boolean {
        val response =
            client.post(SuperTokensRoutes.Totp.REMOVE_DEVICE) {
                setBody(TotpDeviceRequestDTO(deviceName = name))
            }
        val body = response.body<RemoveTotpDeviceResponseDTO>()
        return when (body.status) {
            SuperTokensStatus.OK.value -> checkNotNull(body.didDeviceExist)
            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
