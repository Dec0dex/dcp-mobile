package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class AuthorizationUrlResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val urlWithQueryParams: String?,
    val pkceCodeVerifier: String? = null,
) : SuperTokensBaseResponseDTO
