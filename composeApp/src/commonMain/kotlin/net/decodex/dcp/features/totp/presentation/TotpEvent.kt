package net.decodex.dcp.features.totp.presentation

sealed interface TotpEvent {
    data object GoBack : TotpEvent

    data object OnDismissErrorDialog : TotpEvent

    data class OnTotpChange(val totp: String) : TotpEvent

    data class OnDeviceNameChange(val deviceName: String) : TotpEvent

    data class CreateDevice(val deviceName: String) : TotpEvent

    data class Verify(val totp: String) : TotpEvent
}
