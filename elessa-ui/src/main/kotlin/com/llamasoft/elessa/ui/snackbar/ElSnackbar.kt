package com.llamasoft.elessa.ui.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElDimens
import kotlinx.coroutines.delay
import kotlin.math.max
import kotlin.math.min

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ElSnackbar(
    modifier: Modifier = Modifier,
    text: String,
    autoCloseTime: Double = 4.0,
    accessibilityText: (SemanticsPropertyReceiver.() -> Unit)? = null,
) {
    var visible by remember { mutableStateOf(false) }
    val dimens = LocalElDimens.current

    Surface(
        modifier = modifier
            .shadow(1.dp, shape = MaterialTheme.shapes.large)
            .clip(MaterialTheme.shapes.large),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        FlowRow(
            modifier = Modifier.padding(dimens.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(dimens.spacing.medium),
            horizontalArrangement = Arrangement.spacedBy(dimens.spacing.xSmall)
        ) {
            Text(
                modifier = Modifier
                    .semantics {
                        accessibilityText?.let { it() }
                    },
                text = text,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodySmall
                    .copy(
                        color = MaterialTheme.colorScheme.onSurface,
                    ),
            )
        }
    }

    LaunchedEffect(true) {
        visible = true
    }
    val rangeAdjustedAutoCloseTime =
        min(
            max(autoCloseTime, AUTO_CLOSE_TIME_RANGE.start),
            AUTO_CLOSE_TIME_RANGE.endInclusive
        )
    LaunchedEffect(Unit) {
        delay((rangeAdjustedAutoCloseTime * 1000).toLong())
        visible = false
    }
}

private val AUTO_CLOSE_TIME_RANGE = 4.0..15.0

@Preview(
    showBackground = true,
    heightDp = 80,
    widthDp = 400
)
@Composable
fun ElSnackbarPreview() {
    ElessaTheme {
        ElSnackbar(
            modifier = Modifier.padding(16.dp),
            text = "This is a snackbar",
            autoCloseTime = 4.0,
            accessibilityText = {
                contentDescription = "This is a snackbar"
            }
        )
    }
}
