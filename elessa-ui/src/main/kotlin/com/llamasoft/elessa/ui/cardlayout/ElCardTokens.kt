package com.llamasoft.elessa.ui.cardlayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.ElColorPalette
import com.llamasoft.elessa.ui.theme.LocalElColors

sealed class ElCardStyleType {
    data object Disabled: ElCardStyleType()
    data object Low: ElCardStyleType()
    data object Medium: ElCardStyleType()
    data object High : ElCardStyleType()
    data object Closeable : ElCardStyleType()
}

class ElCardTokens(
    val backgroundBrush: Brush,
    val textColor: Color,
    val elevation: Dp
)

@Composable
fun ElCardStyleType.tokens(): ElCardTokens {
    val colors = LocalElColors.current

    return when (this) {
        ElCardStyleType.Disabled -> ElCardTokens(
            backgroundBrush = Brush.horizontalGradient(
                listOf(colors.disableContainer, colors.disableContainer)
            ),
            textColor = colors.onDisableContainer,
            elevation = 0.dp
        )
        ElCardStyleType.Low -> ElCardTokens(
            backgroundBrush = Brush.horizontalGradient(
                listOf(colors.lowContainer, colors.lowContainer)
            ),
            textColor = colors.onLowContainer,
            elevation = 4.dp
        )
        ElCardStyleType.Medium -> ElCardTokens(
            backgroundBrush = Brush.horizontalGradient(
                listOf(colors.primaryContainer, colors.primaryContainer)
            ),
            textColor = colors.onPrimaryContainer,
            elevation = 4.dp
        )
        ElCardStyleType.High -> ElCardTokens(
            backgroundBrush = Brush.linearGradient(
                colors = listOf(
                    colors.secondaryContainerVariant,
                    Color(0xFF50007F),
                    colors.primaryContainerVariant
                ),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            ),
            textColor = colors.onTertiary,
            elevation = 4.dp
        )
        ElCardStyleType.Closeable -> ElCardTokens(
            backgroundBrush = Brush.linearGradient(
                colors = listOf(
                    ElColorPalette.UI_LS_PRIMARY_500,
                    ElColorPalette.UI_LS_PRIMARY_500,
                    ElColorPalette.UI_LS_PRIMARY_500
                )
            ),
            textColor = Color.White,
            elevation = 4.dp
        )
    }
}
