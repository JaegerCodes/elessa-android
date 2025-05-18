package com.llamasoft.elessa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.llamasoft.elessa.ui.R

/**
 * Typography tokens for the Elessa UI.
 */
@Immutable
class ElTypographyTokens(
    val headingLarge: TextStyle,
    val headingLargeBold: TextStyle,
    val headingMedium: TextStyle,
    val headingMediumBold: TextStyle,
    val headingSmall: TextStyle,
    val headingXSmall: TextStyle,
    val bodyMedium: TextStyle,
    val bodyMediumBold: TextStyle,
    val bodyLinkMedium: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallBold: TextStyle,
    val bodyLinkSmall: TextStyle,
    val bodyXSmall: TextStyle,
    val bodyXSmallBold: TextStyle,
    val bodyLinkXSmall: TextStyle,
    val labelLarge: TextStyle,
    val labelSmall: TextStyle,
    val helperMedium: TextStyle,
    val helperMediumBold: TextStyle,
    val helperLinkMedium: TextStyle,
    val helperXSmall: TextStyle,
    val helperXSmallBold: TextStyle,
    val helperLinkXSmall: TextStyle,
    val numberXLargeBold: TextStyle,
    val numberLargeBold: TextStyle,
    val numberMediumBold: TextStyle,
    val numberSmall: TextStyle,
    val numberSmallBold: TextStyle,
    val numberXSmall: TextStyle,
    val numberXSmallBold: TextStyle,
    val numberStrikethroughXSmall: TextStyle,
    val numberXxSmall: TextStyle,
    val numberXxSmallBold: TextStyle,
    val bottomNavLabel: TextStyle,
    val badges: TextStyle,
    val userID: TextStyle,
)

internal fun defaultElTypographyTokens(elColorScheme: ElColorScheme) = ElTypographyTokens(
    headingLarge = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    headingLargeBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    headingMedium = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    headingMediumBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    headingSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    headingXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyMedium = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyMediumBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyLinkMedium = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.Underline,
    ),
    bodySmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodySmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyLinkSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.Underline,
    ),
    bodyXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyXSmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bodyLinkXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.Underline,
    ),
    labelLarge = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onTertiary,
    ),
    labelSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    helperMedium = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    helperMediumBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    helperLinkMedium = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.Underline,
    ),
    helperXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    helperXSmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    helperLinkXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.Underline,
    ),
    numberXLargeBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberLargeBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberMediumBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberSmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberXSmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberStrikethroughXSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
        textDecoration = TextDecoration.LineThrough,
    ),
    numberXxSmall = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    numberXxSmallBold = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 9.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    bottomNavLabel = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 9.sp,
        letterSpacing = 0.sp,
        color = elColorScheme.onPrimaryContainerVariant,
    ),
    badges = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        color = ElColorPalette.UI_LS_NEUTRAL_800,
        lineHeight = 12.sp
    ),
    userID = TextStyle(
        fontFamily = ElFontFamilies.Gibson,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = ElColorPalette.UI_LS_NEUTRAL_800,
        lineHeight = 24.sp
    )
)

fun customTypography(
    elColorPalette: ElColorScheme = elLightColorScheme,
): Typography {
    val defaultTypography = defaultElTypographyTokens(elColorPalette)
    return Typography(
        displayLarge = defaultTypography.headingLarge,
        displayMedium = defaultTypography.headingMedium,
        displaySmall = defaultTypography.headingSmall,
        headlineLarge = defaultTypography.headingXSmall,
        headlineMedium = defaultTypography.headingMedium,
        headlineSmall = defaultTypography.bodyMediumBold,
        titleLarge = defaultTypography.headingLarge,
        titleMedium = defaultTypography.headingMedium,
        titleSmall = defaultTypography.bodySmallBold,
        bodyLarge = defaultTypography.bodyXSmall,
        bodyMedium = defaultTypography.bodyMedium,
        bodySmall = defaultTypography.bodySmall,
        labelLarge = defaultTypography.labelLarge,
        labelMedium = defaultTypography.labelSmall,
        labelSmall = defaultTypography.helperMedium,
    )
}

@Immutable
private object ElFontFamilies {
    @Stable
    val Gibson = FontFamily(
        Font(resId = R.font.gibson_semi_bold, weight = FontWeight.SemiBold), // Weight = 600
        Font(resId = R.font.gibson_medium, weight = FontWeight.Medium), // Weight = 500
        Font(resId = R.font.gibson_regular, weight = FontWeight.Normal) // Weight = 400
    )
}
