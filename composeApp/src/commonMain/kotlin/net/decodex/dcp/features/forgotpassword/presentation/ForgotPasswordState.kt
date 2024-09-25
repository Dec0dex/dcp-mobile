package net.decodex.dcp.features.forgotpassword.presentation

import org.jetbrains.compose.resources.StringResource

data class ForgotPasswordState(
    val email: String = "",
    val emailError: StringResource? = null,
    val isInputValid: Boolean = false,
    val emailSent: Boolean = false,
    val isLoading: Boolean = false,
    val isErrorVisible: Boolean = false,
    val errorMessage: String? = null,
)
