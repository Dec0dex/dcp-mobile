package net.decodex.dcp

import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import net.decodex.dcp.di.initKoin
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

@Suppress("FunctionName")
fun MainViewController() =
    ComposeUIViewController(
        configure = {
            initKoin {
                Darwin.create()
            }
        },
    ) {
        val isDarkTheme =
            UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
        App(
            darkTheme = isDarkTheme,
            dynamicColor = false,
        )
    }
