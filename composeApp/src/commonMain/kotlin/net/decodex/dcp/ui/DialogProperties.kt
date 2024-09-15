package net.decodex.dcp.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties

expect fun getPlatformDialogProperties(
    dismissOnBackPress: Boolean = true,
    dismissOnClickOutside: Boolean = true,
    usePlatformDefaultWidth: Boolean = true,
    decorFitsSystemWindows: Boolean = true,
    usePlatformInsets: Boolean = true,
    scrimColor: Color = Color.Black.copy(alpha = 0.5f),
): DialogProperties
