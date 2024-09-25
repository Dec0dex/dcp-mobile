package net.decodex.dcp.features.emailotp.presnetation

sealed interface OtpEvent {
    data object SendOtp : OtpEvent

    data object GoBack : OtpEvent

    data object ConfirmCode : OtpEvent

    data object DismissErrorDialog : OtpEvent

    data class OnCodeInput(val code: String) : OtpEvent
}
