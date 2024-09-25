package net.decodex.dcp.features.totp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.models.AuthFactor
import net.decodex.dcp.core.supertokens.recipes.multifactor.MultiFactorAuthRecipe
import net.decodex.dcp.core.supertokens.recipes.totp.TotpRecipe
import net.decodex.dcp.core.supertokens.recipes.totp.usecases.CreateTotpDeviceResult

class TotpViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow<TotpState>(TotpState.Loading)
    val state = _state.asStateFlow()
    lateinit var navigator: NavController
    private var pendingVerifyDeviceData: CreateTotpDeviceResult? = null

    init {
        refreshMfaStatus()
    }

    fun onEvent(event: TotpEvent) {
        when (event) {
            is TotpEvent.CreateDevice -> createDevice(event.deviceName)
            TotpEvent.GoBack -> navigator.navigateUp()
            is TotpEvent.OnDeviceNameChange -> onDeviceNameChange(event.deviceName)
            TotpEvent.OnDismissErrorDialog -> refreshMfaStatus()
            is TotpEvent.OnTotpChange -> onTotpChange(event.totp)
            is TotpEvent.Verify -> verify(event.totp)
        }
    }

    private fun refreshMfaStatus() {
        _state.update { TotpState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val mfaStatus = client.getRecipe<MultiFactorAuthRecipe>().checkMfaStatus()
                if (pendingVerifyDeviceData != null) {
                    goToVerifyDeviceState()
                } else {
                    if (mfaStatus.factors.alreadySetup.contains(AuthFactor.TOTP.key)) {
                        _state.update { TotpState.AddDevice() }
                    } else {
                        _state.update { TotpState.EnterTotp() }
                    }
                }
            } catch (ex: Exception) {
                _state.update { TotpState.Error(ex.message, true) }
            }
        }
    }

    private fun verify(totp: String) {
        _state.update { TotpState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (pendingVerifyDeviceData != null) {
                    client.getRecipe<TotpRecipe>()
                        .verifyDevice(
                            name = pendingVerifyDeviceData?.deviceName ?: "",
                            totp = totp,
                        )
                } else {
                    client.getRecipe<TotpRecipe>()
                        .verify(totp = totp)
                }
                navigateToHomeAndClearStack()
            } catch (ex: Exception) {
                _state.update { TotpState.Error(ex.message, true) }
            }
        }
    }

    private fun createDevice(deviceName: String) {
        _state.update { TotpState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                pendingVerifyDeviceData =
                    client.getRecipe<TotpRecipe>()
                        .createDevice(name = deviceName)
                goToVerifyDeviceState()
            } catch (ex: Exception) {
                _state.update { TotpState.Error(ex.message, true) }
            }
        }
    }

    private fun goToVerifyDeviceState() {
        _state.update {
            TotpState.VerifyDevice(
                deviceName = pendingVerifyDeviceData?.deviceName ?: "",
                secret = pendingVerifyDeviceData?.secret ?: "",
                qrCodeValue = pendingVerifyDeviceData?.qrCodeString ?: "",
            )
        }
    }

    private fun onTotpChange(totp: String) {
        when (_state.value) {
            is TotpState.VerifyDevice -> _state.update { (it as TotpState.VerifyDevice).copy(totp = totp) }
            is TotpState.EnterTotp -> _state.update { (it as TotpState.EnterTotp).copy(totp = totp) }
            else -> throw Error("Unsupported Event under the state: ${_state.value}")
        }
    }

    private fun onDeviceNameChange(value: String) {
        when (_state.value) {
            is TotpState.AddDevice -> _state.update { (it as TotpState.AddDevice).copy(deviceName = value) }
            else -> throw Error("Unsupported Event under the state: ${_state.value}")
        }
    }

    private fun navigateToHomeAndClearStack() {
        navigator.popBackStack()
        navigator.graph.setStartDestination(NavRoutes.HOME)
        navigator.navigate(NavRoutes.HOME) {
            popUpTo(NavRoutes.HOME)
        }
    }
}
