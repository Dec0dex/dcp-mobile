package net.decodex.dcp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun LoadingOverlay(
    isLoading: Boolean,
    modifier: Modifier = Modifier.fillMaxSize(),
    backgroundColor: Color = Color.Black.copy(alpha = 0.5f),
    hideKeyBoardWhenLoading: Boolean = true,
) {
    if (isLoading) {
        if (hideKeyBoardWhenLoading) {
            val keyboardController = LocalSoftwareKeyboardController.current
            keyboardController?.hide()
        }

        Box(
            modifier =
                modifier
                    .fillMaxSize()
                    .background(color = backgroundColor)
                    .pointerInput(Unit) { // Consumes all input events
                        // This will block all touch events
                    },
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp),
            )
        }
    }
}
