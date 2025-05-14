package com.llamasoft.elessa.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * elessa-ui colors
 */
@Immutable
class ElColorScheme(
    val primary: Color,
    val onPrimary: Color,

    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val primaryContainerVariant: Color,
    val onPrimaryContainerVariant: Color,

    val secondary: Color,
    val onSecondary: Color,

    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val secondaryContainerVariant: Color,

    val tertiary: Color,
    val onTertiary: Color,

    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val surface: Color,
    val onSurface: Color,
    val outline: Color,
    val outlineVariant: Color,

    val disableContainer: Color,
    val onDisableContainer: Color,

    val lowContainer: Color,
    val onLowContainer: Color,
)

fun customColorScheme(
    elColorScheme: ElColorScheme,
): ColorScheme = ColorScheme(
    primary = elColorScheme.primary,
    onPrimary = elColorScheme.onPrimary,

    primaryContainer = elColorScheme.primaryContainer,
    onPrimaryContainer = elColorScheme.onPrimaryContainer,
    inversePrimary = ElColorPalette.UI_LS_PRIMARY_300,

    secondary = elColorScheme.secondary,
    onSecondary = elColorScheme.onSecondary,

    secondaryContainer = elColorScheme.secondaryContainer,
    onSecondaryContainer = elColorScheme.onSecondaryContainer,

    tertiary = elColorScheme.tertiary,
    onTertiary = elColorScheme.onTertiary,

    tertiaryContainer = ElColorPalette.UI_LS_INFO_200,
    onTertiaryContainer = ElColorPalette.UI_LS_NEUTRAL_800,

    background = ElColorPalette.UI_LS_NEUTRAL_200,
    onBackground = ElColorPalette.UI_LS_NEUTRAL_800,

    surface = elColorScheme.surface,
    onSurface = elColorScheme.onSurface,

    surfaceVariant = ElColorPalette.UI_LS_NEUTRAL_300,
    onSurfaceVariant = ElColorPalette.UI_LS_NEUTRAL_700,
    surfaceTint = ElColorPalette.UI_LS_PRIMARY_500,

    inverseSurface = ElColorPalette.UI_LS_NEUTRAL_800,
    inverseOnSurface = ElColorPalette.UI_LS_NEUTRAL_100,

    error = elColorScheme.error,
    onError = elColorScheme.onError,
    errorContainer = elColorScheme.errorContainer,
    onErrorContainer = elColorScheme.onErrorContainer,

    outline = elColorScheme.outline,
    outlineVariant = elColorScheme.outlineVariant,

    scrim = ElColorPalette.UI_LS_NEUTRAL_800.copy(alpha = 0.5f),

    surfaceBright = ElColorPalette.UI_LS_NEUTRAL_100,
    surfaceDim = ElColorPalette.UI_LS_NEUTRAL_300,
    surfaceContainer = ElColorPalette.UI_LS_NEUTRAL_200,
    surfaceContainerHigh = ElColorPalette.UI_LS_NEUTRAL_300,
    surfaceContainerHighest = ElColorPalette.UI_LS_NEUTRAL_100,
    surfaceContainerLow = ElColorPalette.UI_LS_NEUTRAL_400,
    surfaceContainerLowest = ElColorPalette.UI_LS_NEUTRAL_900
)

/**
 * Light colors
 */
internal val elLightColorScheme = ElColorScheme(
    primary = ElColorPalette.UI_LS_PRIMARY_500,
    onPrimary = ElColorPalette.UI_LS_NEUTRAL_100,

    primaryContainer = ElColorPalette.UI_LS_PRIMARY_200,
    onPrimaryContainer = ElColorPalette.UI_LS_NEUTRAL_900,
    primaryContainerVariant = ElColorPalette.UI_LS_PRIMARY_500,
    onPrimaryContainerVariant = ElColorPalette.UI_LS_PRIMARY_800,

    secondary = ElColorPalette.UI_LS_SECONDARY_600,
    onSecondary = ElColorPalette.UI_LS_NEUTRAL_100,

    secondaryContainer = ElColorPalette.UI_LS_SECONDARY_200,
    onSecondaryContainer = ElColorPalette.UI_LS_SECONDARY_700,
    secondaryContainerVariant = ElColorPalette.UI_LS_SECONDARY_500,

    tertiary = ElColorPalette.UI_LS_INFO_600,
    onTertiary = ElColorPalette.UI_LS_NEUTRAL_200,

    lowContainer = ElColorPalette.UI_LS_NEUTRAL_100,
    onLowContainer = ElColorPalette.UI_LS_NEUTRAL_800,

    disableContainer = ElColorPalette.UI_LS_NEUTRAL_100,
    onDisableContainer = ElColorPalette.UI_LS_NEUTRAL_500,

    error = ElColorPalette.UI_LS_ERROR_600,
    onError = ElColorPalette.UI_LS_NEUTRAL_100,
    errorContainer = ElColorPalette.UI_LS_ERROR_200,
    onErrorContainer = ElColorPalette.UI_LS_NEUTRAL_800,
    surface = ElColorPalette.UI_LS_NEUTRAL_200,
    onSurface = ElColorPalette.UI_LS_NEUTRAL_800,
    outline = ElColorPalette.UI_LS_NEUTRAL_400,
    outlineVariant = ElColorPalette.UI_LS_NEUTRAL_300,
)

/**
 * Valores de los colores del modo claro de Equis.
 */
internal object ElColorPalette {
    val UI_LS_NEUTRAL_100 = Color(0xFFFFFFFF)
    val UI_LS_NEUTRAL_200 = Color(0xFFFAFAFA)
    val UI_LS_NEUTRAL_300 = Color(0xFFE8E8E8)
    val UI_LS_NEUTRAL_400 = Color(0xFFD1D1D1)
    val UI_LS_NEUTRAL_500 = Color(0xFFB2B2B2)
    val UI_LS_NEUTRAL_600 = Color(0xFF767676)
    val UI_LS_NEUTRAL_700 = Color(0xFF5B5B5B)
    val UI_LS_NEUTRAL_800 = Color(0xFF333333)
    val UI_LS_NEUTRAL_900 = Color(0xFF000000)
    val UI_LS_PRIMARY_100 = Color(0xFFDCCBE5)
    val UI_LS_PRIMARY_200 = Color(0xFFF3EEF6)
    val UI_LS_PRIMARY_300 = Color(0xFFB999CB)
    val UI_LS_PRIMARY_400 = Color(0xFF844DA5)
    val UI_LS_PRIMARY_500 = Color(0xFF50007F)
    val UI_LS_PRIMARY_600 = Color(0xFF44006C)
    val UI_LS_PRIMARY_700 = Color(0xFF3A005C)
    val UI_LS_PRIMARY_800 = Color(0xFF30004C)
    val UI_LS_SECONDARY_200 = Color(0xFFFEE4D9)
    val UI_LS_SECONDARY_300 = Color(0xFFFEC1A6)
    val UI_LS_SECONDARY_400 = Color(0xFFFE9E73)
    val UI_LS_SECONDARY_500 = Color(0xFFFE5000)
    val UI_LS_SECONDARY_600 = Color(0xFFCB4000)
    val UI_LS_SECONDARY_700 = Color(0xFF983000)
    val UI_LS_SECONDARY_800 = Color(0xFF7E2700)
    val UI_LS_WARNING_200 = Color(0xFFFCF0CE)
    val UI_LS_WARNING_300 = Color(0xFFFFE4AB)
    val UI_LS_WARNING_400 = Color(0xFFFFD987)
    val UI_LS_WARNING_500 = Color(0xFFFFB30F)
    val UI_LS_WARNING_600 = Color(0xFF996B09)
    val UI_LS_WARNING_700 = Color(0xFF735006)
    val UI_LS_WARNING_800 = Color(0xFF5A3F05)
    val UI_LS_ERROR_200 = Color(0xFFFBE9E9)
    val UI_LS_ERROR_300 = Color(0xFFF4BBBB)
    val UI_LS_ERROR_400 = Color(0xFFED8F8F)
    val UI_LS_ERROR_500 = Color(0xFFDB1F1F)
    val UI_LS_ERROR_600 = Color(0xFFBA1A1A)
    val UI_LS_ERROR_700 = Color(0xFF991515)
    val UI_LS_ERROR_800 = Color(0xFF791111)
    val UI_LS_SUCCESS_200 = Color(0xFFE4F3E7)
    val UI_LS_SUCCESS_300 = Color(0xFFC2E5C9)
    val UI_LS_SUCCESS_400 = Color(0xFF86CC95)
    val UI_LS_SUCCESS_500 = Color(0xFF24A33F)
    val UI_LS_SUCCESS_600 = Color(0xFF19722C)
    val UI_LS_SUCCESS_700 = Color(0xFF11511F)
    val UI_LS_SUCCESS_800 = Color(0xFF0E411A)
    val UI_LS_INFO_200 = Color(0xFFE6EEFA)
    val UI_LS_INFO_300 = Color(0xFFC3D7F3)
    val UI_LS_INFO_400 = Color(0xFF7BA7E5)
    val UI_LS_INFO_500 = Color(0xFF1160D0)
    val UI_LS_INFO_600 = Color(0xFF0D4CA6)
    val UI_LS_INFO_700 = Color(0xFF0A397C)
    val UI_LS_INFO_800 = Color(0xFF083068)
}