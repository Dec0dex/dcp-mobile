package net.decodex.dcp.core.supertokens.recipes.totp.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.requests.VerifyTotpDeviceRequestDTO
import net.decodex.dcp.core.supertokens.responses.StatusResponseDTO

internal class VerifyTotpDeviceUseCase(
    private val client: HttpClient,
) {
    suspend fun verifyDevice(
        deviceName: String,
        totp: String,
    ): SuperTokensStatus {
        val response =
            client.post(SuperTokensRoutes.Totp.VERIFY_DEVICE) {
                setBody(VerifyTotpDeviceRequestDTO(deviceName = deviceName, totp = totp))
            }
        val body = response.body<StatusResponseDTO>()
        return body.status.toStatus()
    }
}
