package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus
import net.decodex.dcp.core.supertokens.models.PasswordlessMode

@Serializable
data class StartPasswordlessSignInUpResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val deviceId: String? = null,
    val preAuthSessionId: String? = null,
    val flowType: PasswordlessMode? = null,
) : SuperTokensBaseResponseDTO
