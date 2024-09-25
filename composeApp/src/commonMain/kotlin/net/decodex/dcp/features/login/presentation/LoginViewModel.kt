package net.decodex.dcp.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.myunidays.launchdarkly.LDClient
import com.myunidays.launchdarkly.LDContext
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
import net.decodex.dcp.core.supertokens.models.SuperTokensUser
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPassword
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Apple
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Facebook
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.GitHub
import net.decodex.dcp.core.supertokens.recipes.thirdparty.providers.Google
import net.decodex.dcp.core.utils.Validators
import org.jetbrains.compose.resources.StringResource

class LoginViewModel(
    private val client: SuperTokensClient,
    private val ldClient: LDClient,
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()
    lateinit var navigator: NavHostController

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
            LoginEvent.OnRegisterClicked -> navigateToRegisterScreen()
            LoginEvent.OnForgotPasswordClicked -> navigateToForgotPasswordScreen()

            LoginEvent.OnLoginClick ->
                viewModelScope.launch(Dispatchers.IO) {
                    login { loginWithEmailPasswordAction() }
                }

            LoginEvent.SignInWithGoogle ->
                viewModelScope.launch(Dispatchers.IO) {
                    login { loginWithGoogleAction().user }
                }

            LoginEvent.SignInWithFacebook ->
                viewModelScope.launch(Dispatchers.IO) {
                    login { loginWithFacebookAction().user }
                }

            LoginEvent.SignInWithGitHub ->
                viewModelScope.launch(Dispatchers.IO) {
                    login { loginWithGithubAction().user }
                }

            LoginEvent.SignInWithApple ->
                viewModelScope.launch(Dispatchers.IO) {
                    login { loginWithAppleAction().user }
                }
        }
    }

    private suspend fun login(action: suspend () -> SuperTokensUser) {
        _state.update { it.copy(isLoading = true) }
        try {
            val user = action()
            ldClient.identify(LDContext(user.id))
            _state.update { it.copy(isLoading = false) }
            withContext(Dispatchers.Main) { navigateToHome() }
        } catch (ex: SuperTokensStatusException) {
            _state.update {
                it.copy(
                    isErrorVisible = true,
                    apiError = ex.message,
                    isLoading = false,
                )
            }
        } catch (ex: Exception) {
            _state.update {
                it.copy(
                    isErrorVisible = true,
                    isLoading = false,
                    apiError = ex.message,
                )
            }
        }
    }

    private suspend fun loginWithEmailPasswordAction() =
        client.signInWith(EmailPassword) {
            email = _state.value.email
            password = _state.value.password
        }

    private suspend fun loginWithGoogleAction() = client.signInWith(Google.Tokens) {}

    private suspend fun loginWithGithubAction() = client.signInWith(GitHub.Tokens) {}

    private suspend fun loginWithFacebookAction() = client.signInWith(Facebook.Tokens) {}

    private suspend fun loginWithAppleAction() = client.signInWith(Apple.Tokens) {}

    private fun navigateToHome() {
        navigator.navigate(NavRoutes.HOME) {
            popUpTo(NavRoutes.LOGIN) { inclusive = true }
        }
    }

    private fun navigateToRegisterScreen() {
        navigator.navigate(NavRoutes.REGISTER)
    }

    private fun navigateToForgotPasswordScreen() {
        navigator.navigate(NavRoutes.FORGOT_PASSWORD)
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
