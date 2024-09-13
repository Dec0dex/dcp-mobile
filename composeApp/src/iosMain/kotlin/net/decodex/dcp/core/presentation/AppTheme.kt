package net.decodex.dcp.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import net.decodex.dcp.ui.theme.AppTypography
import net.decodex.dcp.ui.theme.darkScheme
import net.decodex.dcp.ui.theme.lightScheme

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkScheme else lightScheme,
        typography = AppTypography(),
        content = content,
    )
}
