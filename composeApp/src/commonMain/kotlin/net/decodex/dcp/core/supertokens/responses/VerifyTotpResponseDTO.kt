package net.decodex.dcp.core.supertokens.responses

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensStatus

@Serializable
data class VerifyTotpResponseDTO(
    override val status: String = SuperTokensStatus.OK.value,
    val currentNumberOfFailedAttempts: Long? = null,
    val maxNumberOfFailedAttempts: Long? = null,
    val retryAfterMs: Long? = null,
) : SuperTokensBaseResponseDTO
