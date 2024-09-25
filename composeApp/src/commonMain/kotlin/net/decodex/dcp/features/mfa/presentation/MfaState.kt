package net.decodex.dcp.features.mfa.presentation

import net.decodex.dcp.core.supertokens.models.MultiFactorAuthStatus

data class MfaState(
    val isLoading: Boolean = false,
    val mfaStatus: MultiFactorAuthStatus? = null,
    val isErrorVisible: Boolean = false,
    val errorMessage: String? = null,
)
