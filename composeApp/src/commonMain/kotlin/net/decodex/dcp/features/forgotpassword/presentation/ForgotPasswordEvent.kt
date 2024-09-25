package net.decodex.dcp.features.forgotpassword.presentation

sealed interface ForgotPasswordEvent {
    data object SendEmail : ForgotPasswordEvent

    data object GoBack : ForgotPasswordEvent

    data class OnEmailChange(val value: String) : ForgotPasswordEvent
}
