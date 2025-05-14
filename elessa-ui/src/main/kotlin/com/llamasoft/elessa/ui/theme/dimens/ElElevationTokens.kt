package com.llamasoft.elessa.ui.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class ElElevationTokens(
    val level1: Dp,
    val level2: Dp,
    val level3: Dp,
)

internal val defaultElElevationTokens = ElElevationTokens(
    level1 = 1.dp,
    level2 = 3.dp,
    level3 = 6.dp,
)
