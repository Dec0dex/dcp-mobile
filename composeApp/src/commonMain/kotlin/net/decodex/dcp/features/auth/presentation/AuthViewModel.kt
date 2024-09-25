package net.decodex.dcp.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.session.SessionRecipe

class AuthViewModel(private val client: SuperTokensClient) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()
    lateinit var navigator: NavHostController

    fun authorizeUser() {
        viewModelScope.launch(Dispatchers.IO) {
            refreshToken()
        }
    }

    private suspend fun refreshToken() {
        try {
            client.getRecipe<SessionRecipe>().refreshTokens()
            withContext(Dispatchers.Main) {
                navigator.navigate(NavRoutes.HOME) {
                    popUpTo(NavRoutes.AUTH) { inclusive = true }
                }
            }
        } catch (ex: Exception) {
            withContext(Dispatchers.Main) {
                navigator.navigate(NavRoutes.LOGIN) {
                    popUpTo(NavRoutes.AUTH) { inclusive = true }
                }
            }
        }
    }
}
