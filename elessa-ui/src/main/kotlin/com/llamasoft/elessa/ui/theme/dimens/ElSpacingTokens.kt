package com.llamasoft.elessa.ui.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("LongParameterList")
@Immutable
class ElSpacingTokens(
    val xxSmall: Dp,
    val xSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val xLarge: Dp,
    val margin: Dp,
)

internal val defaultElSpacingTokens = ElSpacingTokens(
    xxSmall = 4.dp,
    xSmall = 8.dp,
    small = 12.dp,
    medium = 16.dp,
    large = 24.dp,
    xLarge = 32.dp,
    margin = 16.dp,
)
