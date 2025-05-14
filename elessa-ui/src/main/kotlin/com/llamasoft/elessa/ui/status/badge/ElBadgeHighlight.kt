package com.llamasoft.elessa.ui.status.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElColors
import com.llamasoft.elessa.ui.theme.LocalElTypography

@Composable
fun ElBadgeHighlight(
    text: String,
    style: ElBadgeHighlightStyle,
    modifier: Modifier = Modifier
) {
    val colors = LocalElColors.current
    val typography = LocalElTypography.current
    val backgroundColor = when (style) {
        ElBadgeHighlightStyle.POSITIVE -> colors.success
        ElBadgeHighlightStyle.INFORMATIVE -> colors.info
        ElBadgeHighlightStyle.PRIMARY -> colors.primary
        ElBadgeHighlightStyle.SECONDARY -> colors.secondary
    }

    Row(
        modifier = modifier.wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .background(backgroundColor)
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 4.dp, vertical = 2.dp)
        ) {
            Text(
                text = text,
                style = typography.bodyXSmall,
                color = colors.onPrimary,
                modifier = Modifier.semantics {
                    this.text = AnnotatedString(text)
                }
            )
        }
    }
}

/**
 * Eq badge highlight style
 *
 * enum que representa los estilos que puede tomar el componente EqBadgeHighlight
 */
enum class ElBadgeHighlightStyle {
    POSITIVE, INFORMATIVE, PRIMARY, SECONDARY
}

@Preview(showBackground = true)
@Composable
internal fun EqBadgeHighlightPreview() {
    ElessaTheme {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElBadgeHighlight(text = "+46.2%", style = ElBadgeHighlightStyle.POSITIVE)
            Spacer(modifier = Modifier.height(16.dp))
            ElBadgeHighlight(
                text = "6 cuotas sin intereses",
                style = ElBadgeHighlightStyle.POSITIVE
            )
            Spacer(modifier = Modifier.height(16.dp))
            ElBadgeHighlight(text = "CyberMonday", style = ElBadgeHighlightStyle.INFORMATIVE)
            Spacer(modifier = Modifier.height(16.dp))
            ElBadgeHighlight(text = "Solo por hoy", style = ElBadgeHighlightStyle.PRIMARY)
            Spacer(modifier = Modifier.height(16.dp))
            ElBadgeHighlight(text = "Pa' que te rinda", style = ElBadgeHighlightStyle.SECONDARY)
        }
    }
}