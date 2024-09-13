package net.decodex.dcp

import androidx.compose.runtime.Composable
import net.decodex.dcp.core.presentation.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor,
    ) {
    }
}
