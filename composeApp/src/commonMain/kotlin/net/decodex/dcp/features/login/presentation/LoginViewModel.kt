package net.decodex.dcp.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.email_is_not_valid
import dcp_mobile.composeapp.generated.resources.email_is_required
import dcp_mobile.composeapp.generated.resources.password_is_not_long_enough
import dcp_mobile.composeapp.generated.resources.password_should_have_digit
import dcp_mobile.composeapp.generated.resources.password_should_have_mix_of_chars
import dcp_mobile.composeapp.generated.resources.password_should_have_special
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.handlers.signInWith
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPassword
import net.decodex.dcp.core.utils.Validators
import org.jetbrains.compose.resources.StringResource

class LoginViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged ->
                _state.update {
                    it.copy(
                        email = event.value,
                        emailError = validateEmail(event.value),
                        isInputValid = validateInputs(email = event.value, password = it.password),
                    )
                }

            is LoginEvent.OnPasswordChanged ->
                _state.update {
                    it.copy(
                        password = event.value,
                        passwordError = validatePassword(event.value),
                        isInputValid = validateInputs(email = it.email, password = event.value),
                    )
                }

            LoginEvent.DismissErrorDialog -> _state.update { it.copy(isErrorVisible = false) }
            LoginEvent.OnRegisterClicked -> TODO()
            LoginEvent.OnForgotPasswordClicked -> TODO()
            LoginEvent.OnLoginClick -> viewModelScope.launch(Dispatchers.IO) { login() }
            LoginEvent.SignInWithGoogle -> TODO()
            LoginEvent.SignInWithFacebook -> TODO()
            LoginEvent.SignInWithGitHub -> TODO()
            LoginEvent.SignInWithGitLab -> TODO()
            LoginEvent.SignInWithBitbucket -> TODO()
            LoginEvent.SignInWithApple -> TODO()
        }
    }

    private suspend fun login() {
        _state.update { it.copy(isLoading = true) }
        try {
            client.signInWith(EmailPassword) {
                email = _state.value.email
                password = _state.value.password
            }
            _state.update { it.copy(isLoading = false) }
            // TODO: Navigate
        } catch (ex: SuperTokensStatusException) {
            _state.update { it.copy(isErrorVisible = true, apiError = ex, isLoading = false) }
        } catch (ex: Exception) {
            println(ex)
            _state.update { it.copy(isErrorVisible = true, isLoading = false) }
        }
    }

    private fun validateInputs(
        email: String?,
        password: String?,
    ): Boolean {
        return !email.isNullOrEmpty() && !password.isNullOrEmpty() &&
            Validators.isValidEmail(email) && Validators.isValidPassword(password)
    }

    private fun validateEmail(email: String?): StringResource? {
        return if (email.isNullOrEmpty()) {
            Res.string.email_is_required
        } else if (!Validators.isValidEmail(email)) {
            Res.string.email_is_not_valid
        } else {
            null
        }
    }

    private fun validatePassword(password: String): StringResource? {
        val isLongEnough = password.length >= 8
        if (!isLongEnough) return Res.string.password_is_not_long_enough

        val hasEnoughDigits = password.count(Char::isDigit) > 0
        if (!hasEnoughDigits) return Res.string.password_should_have_digit

        val isMixedCase = password.any(Char::isLowerCase) && password.any(Char::isUpperCase)
        if (!isMixedCase) return Res.string.password_should_have_mix_of_chars

        val hasSpecialChar = password.any { it in " !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~" }
        if (!hasSpecialChar) return Res.string.password_should_have_special

        return null
    }
}
