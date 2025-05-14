package com.llamasoft.elessa.ui.pill

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.ElColorPalette
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElTypography

@Composable
fun ElPill(
    title: String,
    color: Color,
    accessibilityText: String? = null
) {
    val typography = LocalElTypography.current
    Row(
        modifier = Modifier.wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .background(color)
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 4.dp, vertical = 2.dp)
        ) {
            Text(
                text = title,
                style = typography.badges,
                color = ElColorPalette.UI_LS_NEUTRAL_100,
                modifier = Modifier
                    .semantics {
                        accessibilityText?.let {
                            this.text = AnnotatedString(accessibilityText)
                        } ?: run {
                            this.text = AnnotatedString(title)
                        }
                    }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ElessaTheme {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElPill(title = "1% TNA", color = ElColorPalette.UI_LS_SUCCESS_600)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
