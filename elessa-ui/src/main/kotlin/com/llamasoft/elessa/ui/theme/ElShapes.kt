package com.llamasoft.elessa.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

fun customShapes(
    elShapeTokens: ElShapeTokens
) = Shapes(
    small = elShapeTokens.small,
    extraSmall = elShapeTokens.xSmall,
    medium = elShapeTokens.medium,
    large = elShapeTokens.large,
    extraLarge = elShapeTokens.xLarge,
)

@Suppress("LongParameterList")
@Immutable
class ElShapeTokens(
    val none: RoundedCornerShape,
    val xSmall: RoundedCornerShape,
    val small: RoundedCornerShape,
    val medium: RoundedCornerShape,
    val large: RoundedCornerShape,
    val xLarge: RoundedCornerShape,
    val full: RoundedCornerShape,
)

/**
 * Default radius tokens.
 */
internal val defaultElShapeTokens = ElShapeTokens(
    none = RoundedCornerShape(0.dp),
    xSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    xLarge = RoundedCornerShape(20.dp),
    full = RoundedCornerShape(percent = 50)
)
