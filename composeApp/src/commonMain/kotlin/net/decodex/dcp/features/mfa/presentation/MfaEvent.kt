package net.decodex.dcp.features.mfa.presentation

sealed interface MfaEvent {
    data object RefreshStatus : MfaEvent

    data object GotoTotp : MfaEvent

    data object GotoPhoneOtp : MfaEvent

    data object GotoEmailOtp : MfaEvent

    data object Cancel : MfaEvent

    data object OnErrorDialogDismissed : MfaEvent
}
