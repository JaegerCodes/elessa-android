package com.llamasoft.elessa.ui.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class ElSizeTokens(
    val xxSmall: Dp,
    val xSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val xLarge: Dp,
    val xxLarge: Dp,
    val xxxLarge: Dp,
)

internal val defaultElSizeTokens = ElSizeTokens(
    xxSmall = 16.dp,
    xSmall = 24.dp,
    small = 32.dp,
    medium = 40.dp,
    large = 48.dp,
    xLarge = 56.dp,
    xxLarge = 120.dp,
    xxxLarge = 160.dp,
)
