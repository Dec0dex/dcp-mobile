package net.decodex.dcp.features.register.presentation

sealed interface RegisterEvent {
    data object OnRegisterClick : RegisterEvent

    data class OnEmailChanged(val value: String) : RegisterEvent

    data class OnPasswordChanged(val value: String) : RegisterEvent

    data object OnLoginClick : RegisterEvent

    data object SignUpWithGoogle : RegisterEvent

    data object SignUpWithFacebook : RegisterEvent

    data object SignUpWithGitHub : RegisterEvent

    data object SignUpWithApple : RegisterEvent

    data object DismissErrorDialog : RegisterEvent
}
