package net.decodex.dcp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.roboto_black
import dcp_mobile.composeapp.generated.resources.roboto_blackItalic
import dcp_mobile.composeapp.generated.resources.roboto_bold
import dcp_mobile.composeapp.generated.resources.roboto_boldItalic
import dcp_mobile.composeapp.generated.resources.roboto_light
import dcp_mobile.composeapp.generated.resources.roboto_lightItalic
import dcp_mobile.composeapp.generated.resources.roboto_medium
import dcp_mobile.composeapp.generated.resources.roboto_mediumItalic
import dcp_mobile.composeapp.generated.resources.roboto_regular
import dcp_mobile.composeapp.generated.resources.roboto_thin
import dcp_mobile.composeapp.generated.resources.roboto_thinItalic
import org.jetbrains.compose.resources.Font

@Composable
fun RobotoFontFamily() =
    FontFamily(
        Font(Res.font.roboto_black, weight = FontWeight.Black),
        Font(Res.font.roboto_blackItalic, weight = FontWeight.Black, style = FontStyle.Italic),
        Font(Res.font.roboto_bold, weight = FontWeight.Bold),
        Font(Res.font.roboto_boldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(Res.font.roboto_light, weight = FontWeight.Light),
        Font(Res.font.roboto_lightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
        Font(Res.font.roboto_medium, weight = FontWeight.Medium),
        Font(Res.font.roboto_mediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(Res.font.roboto_regular, weight = FontWeight.Normal),
        Font(Res.font.roboto_thin, weight = FontWeight.Thin),
        Font(Res.font.roboto_thinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    )

// Default Material 3 typography values
val baseline = Typography()

@Composable
fun AppTypography() =
    Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = RobotoFontFamily()),
        displayMedium = baseline.displayMedium.copy(fontFamily = RobotoFontFamily()),
        displaySmall = baseline.displaySmall.copy(fontFamily = RobotoFontFamily()),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = RobotoFontFamily()),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = RobotoFontFamily()),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = RobotoFontFamily()),
        titleLarge = baseline.titleLarge.copy(fontFamily = RobotoFontFamily()),
        titleMedium = baseline.titleMedium.copy(fontFamily = RobotoFontFamily()),
        titleSmall = baseline.titleSmall.copy(fontFamily = RobotoFontFamily()),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = RobotoFontFamily()),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = RobotoFontFamily()),
        bodySmall = baseline.bodySmall.copy(fontFamily = RobotoFontFamily()),
        labelLarge = baseline.labelLarge.copy(fontFamily = RobotoFontFamily()),
        labelMedium = baseline.labelMedium.copy(fontFamily = RobotoFontFamily()),
        labelSmall = baseline.labelSmall.copy(fontFamily = RobotoFontFamily()),
    )
