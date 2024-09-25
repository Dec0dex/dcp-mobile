package net.decodex.dcp.features.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
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
import kotlinx.coroutines.withContext
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.SuperTokensStatusException
import net.decodex.dcp.core.supertokens.handlers.signInWith
import net.decodex.dcp.core.supertokens.handlers.signUpWith
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPassword
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Apple
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Facebook
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.GitHub
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Google
import net.decodex.dcp.core.utils.Validators
import org.jetbrains.compose.resources.StringResource

class RegisterViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()
    lateinit var navigator: NavHostController

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.OnEmailChanged ->
                _state.update {
                    it.copy(
                        email = event.value,
                        emailError = validateEmail(event.value),
                        isInputValid = validateInputs(email = event.value, password = it.password),
                    )
                }

            is RegisterEvent.OnPasswordChanged ->
                _state.update {
                    it.copy(
                        password = event.value,
                        passwordError = validatePassword(event.value),
                        isInputValid = validateInputs(email = it.email, password = event.value),
                    )
                }

            RegisterEvent.DismissErrorDialog -> _state.update { it.copy(isErrorVisible = false) }
            RegisterEvent.OnLoginClick -> navigateToLogin()

            RegisterEvent.OnRegisterClick ->
                viewModelScope.launch(Dispatchers.IO) {
                    register { registerWithEmailPasswordAction() }
                }

            RegisterEvent.SignUpWithGoogle ->
                viewModelScope.launch(Dispatchers.IO) {
                    register { registerWithGoogleAction() }
                }

            RegisterEvent.SignUpWithFacebook ->
                viewModelScope.launch(Dispatchers.IO) {
                    register { registerWithFacebookAction() }
                }

            RegisterEvent.SignUpWithGitHub ->
                viewModelScope.launch(Dispatchers.IO) {
                    register { registerWithGithubAction() }
                }

            RegisterEvent.SignUpWithApple ->
                viewModelScope.launch(Dispatchers.IO) {
                    register { registerWithAppleAction() }
                }
        }
    }

    private suspend fun register(action: suspend () -> Unit) {
        _state.update { it.copy(isLoading = true) }
        try {
            action()
            _state.update { it.copy(isLoading = false) }
            withContext(Dispatchers.Main) { navigateToHome() }
        } catch (ex: SuperTokensStatusException) {
            _state.update {
                it.copy(
                    isErrorVisible = true,
                    errorMessage = ex.message,
                    isLoading = false,
                )
            }
        } catch (ex: Exception) {
            _state.update {
                it.copy(
                    isErrorVisible = true,
                    isLoading = false,
                    errorMessage = ex.message,
                )
            }
        }
    }

    private suspend fun registerWithEmailPasswordAction() =
        client.signUpWith(EmailPassword) {
            email = _state.value.email
            password = _state.value.password
        }

    private suspend fun registerWithGoogleAction() = client.signInWith(Google.Tokens) {}

    private suspend fun registerWithGithubAction() = client.signInWith(GitHub.Tokens) {}

    private suspend fun registerWithFacebookAction() = client.signInWith(Facebook.Tokens) {}

    private suspend fun registerWithAppleAction() = client.signInWith(Apple.Tokens) {}

    private fun navigateToHome() {
        navigator.popBackStack()
        navigator.graph.setStartDestination(NavRoutes.HOME)
        navigator.navigate(NavRoutes.HOME) {
            popUpTo(NavRoutes.HOME)
        }
    }

    private fun navigateToLogin() {
        navigator.popBackStack()
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
