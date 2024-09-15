package net.decodex.dcp.ui

import androidx.compose.ui.window.DialogProperties

actual fun getPlatformDialogProperties(
    dismissOnBackPress: Boolean,
    dismissOnClickOutside: Boolean,
    usePlatformDefaultWidth: Boolean,
    decorFitsSystemWindows: Boolean,
    usePlatformInsets: Boolean,
    scrimColor: androidx.compose.ui.graphics.Color,
): DialogProperties =
    DialogProperties(
        dismissOnBackPress = dismissOnBackPress,
        dismissOnClickOutside = dismissOnClickOutside,
        usePlatformDefaultWidth = usePlatformDefaultWidth,
        decorFitsSystemWindows = decorFitsSystemWindows,
    )
