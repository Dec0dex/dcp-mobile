package net.decodex.dcp.features.emailotp.presnetation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.myunidays.launchdarkly.LDClient
import com.myunidays.launchdarkly.LDContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.handlers.signInWith
import net.decodex.dcp.core.supertokens.handlers.signUpWith
import net.decodex.dcp.core.supertokens.models.AuthFactor
import net.decodex.dcp.core.supertokens.recipes.passwordless.Passwordless
import net.decodex.dcp.core.supertokens.recipes.passwordless.PasswordlessInputCode

class OtpViewModel(
    private val client: SuperTokensClient,
    private val ldClient: LDClient,
) : ViewModel() {
    private val _state = MutableStateFlow(OtpState())
    private val claims = client.claimsRepository.claims
    val state =
        _state.combine(claims) { state, claims ->
            state.copy(claims = claims, email = claims?.email, phoneNumber = claims?.phoneNumber)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), OtpState())
    private lateinit var navigator: NavHostController
    private lateinit var authFactor: AuthFactor
    private var isInitialized: Boolean = false

    fun init(
        authFactor: AuthFactor,
        navigator: NavHostController,
    ) {
        if (!isInitialized) {
            isInitialized = true
            this.authFactor = authFactor
            this.navigator = navigator
            _state.update { it.copy(isLoading = true, authFactor = authFactor) }
            viewModelScope.launch {
                delay(500L)
                sendOtp()
            }
        }
    }

    fun onEvent(event: OtpEvent) {
        when (event) {
            OtpEvent.DismissErrorDialog -> _state.update { it.copy(isErrorVisible = false) }
            OtpEvent.ConfirmCode -> signIn()
            OtpEvent.GoBack -> navigator.navigateUp()
            OtpEvent.SendOtp -> sendOtp()
            is OtpEvent.OnCodeInput -> _state.update { it.copy(inputCode = event.code) }
        }
    }

    private fun sendOtp() {
        _state.update { it.copy(isLoading = true, otpSent = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val signUpData =
                    if (authFactor == AuthFactor.OtpPhone) {
                        client.signUpWith(Passwordless) { phoneNumber = _state.value.phoneNumber }
                    } else {
                        client.signUpWith(Passwordless) { email = _state.value.phoneNumber }
                    }
                _state.update { it.copy(isLoading = false, signUpData = signUpData) }
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

    private fun signIn() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result =
                    client.signInWith(PasswordlessInputCode) {
                        preAuthSessionId = _state.value.signUpData?.preAuthSessionId
                        deviceId = _state.value.signUpData?.preAuthSessionId
                        userInputCode = _state.value.inputCode
                    }
                ldClient.identify(LDContext(result.user.id))
                _state.update { OtpState() }
                navigateToHomeAndClearStack()
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

    private fun navigateToHomeAndClearStack() {
        navigator.popBackStack()
        navigator.graph.setStartDestination(NavRoutes.HOME)
        navigator.navigate(NavRoutes.HOME) {
            popUpTo(NavRoutes.HOME)
        }
    }
}
