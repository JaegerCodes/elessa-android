package com.llamasoft.elessa.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Immutable
class ElStrokeTokens(
    val smallSolid: BorderStroke,
    val mediumSolid: BorderStroke,
    val largeSolid: BorderStroke,
    val smallDashed: Stroke,
)

@Composable
internal fun defaultElStrokes(elColorScheme: ElColorScheme) = ElStrokeTokens(
    smallSolid = BorderStroke(
        width = 1.dp,
        color = elColorScheme.outlineVariant
    ),
    mediumSolid = BorderStroke(
        width = 2.dp,
        color = elColorScheme.outlineVariant
    ),
    largeSolid = BorderStroke(
        width = 4.dp,
        color = elColorScheme.outlineVariant
    ),
    smallDashed = LocalDensity.current.run {
        Stroke(
            width = 1.dp.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(4.dp.toPx(), 4.dp.toPx()),
                phase = 0f,
            ),
        )
    },
)
