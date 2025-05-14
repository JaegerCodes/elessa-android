package com.llamasoft.elessa.ui.status.badge

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.status.State
import com.llamasoft.elessa.ui.theme.ElColorPalette
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElTypography

const val BadgeTestTag = "BadgeTestTag"

@Composable
fun ElBadge(
    title: String,
    state: String?
) {
    val typography = LocalElTypography.current
    Column(
        modifier =
        Modifier
            .wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
                )
                .background(
                    getBackgroundColorForState(state)
                )
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 12.dp, vertical = 2.dp)
                .testTag(BadgeTestTag)
        ) {
            Text(
                text = title,
                style = typography.badges,
                color = getTextColorForState(state)
            )
        }
    }
}

private fun getBackgroundColorForState(state: String?) = when (state?.lowercase()) {
    State.INFO.state -> State.INFO.backgroundColor
    State.PROCESS.state -> State.PROCESS.backgroundColor
    State.SUCCESS.state -> State.SUCCESS.backgroundColor
    State.WARNING.state -> State.WARNING.backgroundColor
    State.ERROR.state -> State.ERROR.backgroundColor
    State.ORANGE.state -> State.ORANGE.backgroundColor
    State.GREEN.state -> State.GREEN.backgroundColor
    else -> ElColorPalette.UI_LS_NEUTRAL_300
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getTextColorForState(state: String?) = when (state?.lowercase()) {
    State.INFO.state -> State.INFO.textColor
    State.PROCESS.state -> State.PROCESS.textColor
    State.SUCCESS.state -> State.SUCCESS.textColor
    State.WARNING.state -> State.WARNING.textColor
    State.ERROR.state -> State.ERROR.textColor
    State.ORANGE.state -> State.ORANGE.textColor
    State.GREEN.state -> State.GREEN.textColor
    else -> ElColorPalette.UI_LS_NEUTRAL_700
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
            ElBadge(title = "Texto de ejemplo", state = "info")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "process")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "success")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "warning")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "error")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "orange_style")
            Spacer(modifier = Modifier.height(16.dp))
            ElBadge(title = "Texto de ejemplo", state = "green_style")
        }
    }
}
