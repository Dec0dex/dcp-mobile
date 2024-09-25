package net.decodex.dcp.features.login.presentation

sealed interface LoginEvent {
    data object OnLoginClick : LoginEvent

    data class OnEmailChanged(val value: String) : LoginEvent

    data class OnPasswordChanged(val value: String) : LoginEvent

    data object OnRegisterClicked : LoginEvent

    data object OnForgotPasswordClicked : LoginEvent

    data object SignInWithGoogle : LoginEvent

    data object SignInWithFacebook : LoginEvent

    data object SignInWithGitHub : LoginEvent

    data object SignInWithApple : LoginEvent

    data object DismissErrorDialog : LoginEvent
}
