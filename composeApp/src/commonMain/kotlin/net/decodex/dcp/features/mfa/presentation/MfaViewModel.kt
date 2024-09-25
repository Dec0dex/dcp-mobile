package net.decodex.dcp.features.mfa.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.multifactor.MultiFactorAuthRecipe

class MfaViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow(MfaState())
    val state = _state.asStateFlow()
    lateinit var navigator: NavHostController

    init {
        refreshMfaStatus()
    }

    fun onEvent(event: MfaEvent) {
        when (event) {
            MfaEvent.Cancel -> navigator.navigateUp()
            MfaEvent.GotoEmailOtp -> navigator.navigate(NavRoutes.EMAIL_OTP)
            MfaEvent.GotoTotp -> navigator.navigate(NavRoutes.TOTP)
            MfaEvent.GotoPhoneOtp -> navigator.navigate(NavRoutes.PHONE_OTP)
            MfaEvent.RefreshStatus -> refreshMfaStatus()
            MfaEvent.OnErrorDialogDismissed -> _state.update { it.copy(isErrorVisible = false) }
        }
    }

    private fun refreshMfaStatus() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = client.getRecipe<MultiFactorAuthRecipe>().checkMfaStatus()
                _state.update { it.copy(isLoading = false, mfaStatus = result) }
            } catch (ex: Exception) {
                _state.update { it.copy(isLoading = false, isErrorVisible = true, errorMessage = ex.message) }
            }
        }
    }
}
