package net.decodex.dcp.features.forgotpassword.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.email_is_not_valid
import dcp_mobile.composeapp.generated.resources.email_is_required
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPasswordRecipe
import net.decodex.dcp.core.utils.Validators
import org.jetbrains.compose.resources.StringResource

class ForgotPasswordViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow(ForgotPasswordState())
    val state = _state.asStateFlow()
    lateinit var navigator: NavHostController

    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            ForgotPasswordEvent.GoBack -> navigateBack()
            is ForgotPasswordEvent.OnEmailChange ->
                _state.update {
                    it.copy(
                        email = event.value,
                        emailError = validateEmail(event.value),
                        isInputValid = validateInputs(email = event.value),
                    )
                }

            ForgotPasswordEvent.SendEmail -> requestPasswordReset()
        }
    }

    private fun navigateBack() {
        this.navigator.popBackStack()
    }

    private fun validateInputs(email: String?): Boolean {
        return !email.isNullOrEmpty() && Validators.isValidEmail(email)
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

    private fun requestPasswordReset() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                client.getRecipe<EmailPasswordRecipe>().requestPasswordReset(state.value.email)
                _state.update {
                    it.copy(
                        isLoading = false,
                        isErrorVisible = false,
                        emailSent = true,
                        emailError = null,
                    )
                }
            } catch (ex: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        isErrorVisible = true,
                        errorMessage = ex.message,
                    )
                }
            }
        }
    }
}
