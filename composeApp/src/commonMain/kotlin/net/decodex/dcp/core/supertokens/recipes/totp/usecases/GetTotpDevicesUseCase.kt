package net.decodex.dcp.core.supertokens.recipes.totp.usecases

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import net.decodex.dcp.core.supertokens.common.SuperTokensRoutes
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.common.toStatus
import net.decodex.dcp.core.supertokens.models.TotpDevice
import net.decodex.dcp.core.supertokens.responses.GetTotpDevicesResponseDTO

internal class GetTotpDevicesUseCase(
    private val client: HttpClient,
) {
    suspend fun getTotpDevices(): List<TotpDevice> {
        val response = client.get(SuperTokensRoutes.Totp.GET_DEVICES)
        val body = response.body<GetTotpDevicesResponseDTO>()
        return when (body.status) {
            SuperTokensStatus.OK.value ->
                checkNotNull(body.devices).map {
                    TotpDevice(
                        name = it.name,
                        period = it.period,
                        skew = it.skew,
                        verified = it.verified,
                    )
                }

            else -> throw SuperTokensStatusException(body.status.toStatus())
        }
    }
}
