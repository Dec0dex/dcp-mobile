package net.decodex.dcp.features.login.presentation

import org.jetbrains.compose.resources.StringResource

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: StringResource? = null,
    val passwordError: StringResource? = null,
    val isInputValid: Boolean = false,
    val isLoading: Boolean = false,
    val apiError: String? = null,
    val isErrorVisible: Boolean = false,
)
