package com.llamasoft.elessa.presentation.components.button

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.accessibility.getSemanticsProperties
import com.llamasoft.elessa.model.sdui.ElAccessibility

@Composable
fun SquaredButtonContainer(
    accessibility: List<ElAccessibility>?,
    buttonTag: String,
    onClick: () -> Unit,
    contentButton: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
    ) {
        Button(
            shape = RoundedCornerShape(16.dp),
            enabled = true,
            onClick = onClick,
            contentPadding = PaddingValues(
                horizontal = 12.dp,
                vertical = 11.dp
            ),
            modifier = Modifier
                .testTag(buttonTag)
                .wrapContentHeight()
                .animateContentSize()
                .padding(4.dp)
                .defaultMinSize(1.dp)
                .semantics { getSemanticsProperties(accessibility)?.let { it() } },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            contentButton()
        }
    }
}
