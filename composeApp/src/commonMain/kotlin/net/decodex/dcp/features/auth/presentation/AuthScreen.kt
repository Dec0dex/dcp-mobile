package net.decodex.dcp.features.auth.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.decodex.dcp.ui.components.LoadingOverlay

@Composable
fun AuthScreen(
    state: AuthState,
) {
    Scaffold {
        LoadingOverlay(state.isLoading, Modifier.fillMaxSize())
    }
}
