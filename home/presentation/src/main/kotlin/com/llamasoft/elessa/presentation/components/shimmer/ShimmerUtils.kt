package com.llamasoft.elessa.presentation.components.shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.LocalElColors

object ShimmerUtils {

    @Composable
    fun getBrush(): Brush {
        val surfaceVariant = LocalElColors.current.surfaceVariant
        val shimmerColors = listOf(
            surfaceVariant.copy(alpha = 1f),
            surfaceVariant.copy(alpha = 0.3f),
            surfaceVariant.copy(alpha = 0f),
            surfaceVariant.copy(alpha = 0.3f),
            surfaceVariant.copy(alpha = 1f)
        )
        val translateAnimation = getTranslationAnimation()

        return Brush.horizontalGradient(
            colors = shimmerColors,
            startX = translateAnimation.value - 800f,
            endX = translateAnimation.value + 800f
        )
    }

    @Composable
    fun getTranslationAnimation(): State<Float> {
        val transition = rememberInfiniteTransition(label = "")
        return transition.animateFloat(
            initialValue = -800f,
            targetValue = 2000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000
                )
            ),
            label = ""
        )
    }

    @Composable
    fun GetShimmerBlockTitle(modifier: Modifier, roundedSize: Dp = 4.dp) {
        val brush = getBrush()
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(roundedSize))
                .background(brush = brush)
        )
    }
}
