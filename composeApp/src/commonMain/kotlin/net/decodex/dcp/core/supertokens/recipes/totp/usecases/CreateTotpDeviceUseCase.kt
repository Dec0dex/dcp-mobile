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
import net.decodex.dcp.core.supertokens.responses.CreateTotpDeviceResponseDTO

data class CreateTotpDeviceResult(
    val deviceName: String,
    val qrCodeString: String,
    val secret: String,
)

internal class CreateTotpDeviceUseCase(
    private val client: HttpClient,
) {
    suspend fun createDevice(name: String): CreateTotpDeviceResult {
        val response =
            client.post(SuperTokensRoutes.Totp.CREATE_DEVICE) {
                setBody(TotpDeviceRequestDTO(deviceName = name))
            }

        val body = response.body<CreateTotpDeviceResponseDTO>()

        return when (body.status) {
            SuperTokensStatus.OK.value ->
                CreateTotpDeviceResult(
                    deviceName = checkNotNull(body.deviceName),
                    qrCodeString = checkNotNull(body.qrCodeString),
                    secret = checkNotNull(body.secret),
                )

            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
