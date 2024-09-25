package net.decodex.dcp.features.totp.presentation

sealed interface TotpState {
    data object Loading : TotpState

    data class AddDevice(val deviceName: String = "") : TotpState

    data class EnterTotp(val totp: String = "") : TotpState

    data class Error(
        val errorMessage: String? = null,
        val isDialogVisible: Boolean = false,
    ) : TotpState

    data class VerifyDevice(
        val totp: String = "",
        val deviceName: String = "",
        val secret: String = "",
        val qrCodeValue: String = "",
    ) : TotpState
}
