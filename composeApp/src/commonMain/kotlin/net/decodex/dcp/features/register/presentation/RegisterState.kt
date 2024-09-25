package net.decodex.dcp.features.register.presentation

import org.jetbrains.compose.resources.StringResource

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val emailError: StringResource? = null,
    val passwordError: StringResource? = null,
    val isInputValid: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isErrorVisible: Boolean = false,
)
