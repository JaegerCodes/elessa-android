package com.llamasoft.elessa.ui.shortcut

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.llamasoft.elessa.ui.pill.ElPill
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElColors

@Suppress("LongParameterList")
@Composable
fun ElShortcut(
    text: String? = null,
    icon: String? = null,
    enabled: Boolean = true,
    actions: () -> Unit,
    pillTitle: String? = null,
    pillColor: String? = null,
    rippleEffect: Indication? = LocalIndication.current
) {
    val colors = LocalElColors.current

    val containerColor = if (enabled) colors.primaryContainer else colors.disableContainer
    val contentColor = if (enabled) colors.onPrimaryContainer else colors.onDisableContainer
    val titlePill = if (enabled) pillTitle else null
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = actions
            )
    ) {
        Box(
            modifier = Modifier.height(54.dp), contentAlignment = Alignment.TopCenter
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(),
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.BottomCenter)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rippleEffect,
                        onClick = actions
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = containerColor,
                    disabledContainerColor = colors.disableContainer
                ),
                border = BorderStroke(1.dp, colors.outlineVariant)
            ) {
                icon?.let { iconUrl ->
                    Image(
                        painter = rememberAsyncImagePainter(iconUrl),
                        colorFilter = ColorFilter.tint(contentColor),
                        contentDescription = iconUrl,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
            titlePill?.let {
                ElPill(
                    title = titlePill,
                    color = Color(android.graphics.Color.parseColor(pillColor))
                )
            }
        }

        Row(modifier = Modifier.padding(bottom = 4.dp)) {

            text?.let {
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelSmall,
                    color = contentColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = actions
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ElessaTheme {
        ElShortcut(
            text = "Agregar",
            icon = "https://static.prod.naranjadev.com/accounts/shortcuts/deposit.png",
            enabled = false,
            pillTitle = "Nuevo",
            pillColor = "#FE5000",
            actions = { }
        )
    }
}
