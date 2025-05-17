package com.llamasoft.elessa.ui.cardlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.pill.ElPill
import com.llamasoft.elessa.ui.status.badge.ElBadge
import com.llamasoft.elessa.ui.theme.ElessaTheme

@Composable
fun ElCardLayout(
    modifier: Modifier = Modifier,
    title: String? = null,
    titleStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    titleMaxLines: Int = 1,
    subtitle: String? = null,
    subtitleStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    subtitleMaxLines: Int = 2,
    isClickable: Boolean = true,
    cardType: ElCardStyleType = ElCardStyleType.Medium,
    accessibility: (SemanticsPropertyReceiver.() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    pill: @Composable (() -> Unit)? = null,
    badge: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val style = cardType.tokens()

    Card(
        modifier = modifier
            .semantics(mergeDescendants = true) { accessibility?.let { it() } }
            .testTag("EqStyledActionCardTestTag"),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(style.elevation),
        enabled = isClickable,
        onClick = {
            onClick?.run { invoke() }
        }
    ) {
        Box(
            modifier = Modifier
                .background(style.backgroundBrush)
        ) {
            badge?.run { invoke() }
            StyledCardContent(
                title = title,
                titleStyle = titleStyle,
                titleMaxLines = titleMaxLines,
                subtitle = subtitle,
                subtitleStyle = subtitleStyle,
                subtitleMaxLines = subtitleMaxLines,
                icon = icon,
                pill = pill,
                cardStyle = cardType
            )
        }
    }
}

@Composable
private fun StyledCardContent(
    title: String?,
    titleStyle: TextStyle,
    titleMaxLines: Int,
    subtitle: String?,
    subtitleStyle: TextStyle,
    subtitleMaxLines: Int,
    icon: @Composable (() -> Unit)?,
    pill: @Composable (() -> Unit)?,
    cardStyle: ElCardStyleType
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(
            all = 16.dp
        )
    ) {
        icon?.run { invoke() }
        Column {
            pill?.run { invoke() }
            TitleContainer(
                title = title,
                cardStyle = cardStyle,
                titleStyle = titleStyle,
                titleMaxLines = titleMaxLines
            )
            SubtitleContainer(
                subtitle = subtitle,
                cardStyle = cardStyle,
                subtitleStyle = subtitleStyle,
                subtitleMaxLines = subtitleMaxLines
            )
        }
    }
}

@Composable
fun SubtitleContainer(
    subtitle: String?,
    cardStyle: ElCardStyleType,
    subtitleStyle: TextStyle,
    subtitleMaxLines: Int,
    modifier: Modifier = Modifier,
    isAlignmentLeft: Boolean = true
) {
    val style = cardStyle.tokens()
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .align(if (isAlignmentLeft) Alignment.Start else Alignment.End)
                .padding(0.dp, top = 4.dp)
                .semantics { this.text = AnnotatedString("") },
            text = subtitle ?: "",
            style = subtitleStyle,
            color = style.textColor,
            textAlign = if (isAlignmentLeft) TextAlign.Start else TextAlign.End,
            maxLines = subtitleMaxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun TitleContainer(
    title: String?,
    cardStyle: ElCardStyleType,
    titleStyle: TextStyle,
    titleMaxLines: Int,
    modifier: Modifier = Modifier,
    isAlignmentLeft: Boolean = true
) {
    val style = cardStyle.tokens()
    Box(
        modifier = modifier,
        contentAlignment = if (isAlignmentLeft) Alignment.CenterStart else Alignment.CenterEnd
    ) {
        Text(
            modifier = Modifier
                .padding(0.dp)
                .semantics { this.text = AnnotatedString("") },
            text = title ?: "",
            style = titleStyle,
            color = style.textColor,
            textAlign = TextAlign.Start,
            maxLines = titleMaxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true, widthDp = 516)
@Composable
private fun PreviewXLCard(
    @PreviewParameter(LoremIpsum::class)
    testText: String
) {
    ElessaTheme {
        val width = 240.dp
        val image: @Composable (() -> Unit) = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black.copy(alpha = 0.2f))
                    .height(100.dp)
                    .aspectRatio(0.8f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "image")
            }
        }
        Row {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    subtitle = testText,
                    subtitleMaxLines = 4,
                    cardType = ElCardStyleType.Disabled,
                    icon = { image() },
                    badge = {
                        //EqBadge(title = "Warning", state = "warning")
                    }
                )
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    subtitle = testText,
                    subtitleMaxLines = 4,
                    cardType = ElCardStyleType.Medium,
                    icon = {
                        image()
                    }
                )
            }
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    subtitle = testText,
                    subtitleMaxLines = 4,
                    cardType = ElCardStyleType.Low,
                    icon = {
                        image()
                    }
                )
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    subtitle = testText,
                    subtitleMaxLines = 4,
                    cardType = ElCardStyleType.High,
                    icon = {
                        image()
                    },
                    pill = {
                        //EqPill(title = "60% descuento", color = Color.Red)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
private fun PreviewMCard(
    @PreviewParameter(LoremIpsum::class)
    testText: String
) {
    ElessaTheme {
        val width = 240.dp
        val image: @Composable (() -> Unit) = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black.copy(alpha = 0.2f))
                    .height(52.dp)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "image")
            }
        }
        Row {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    titleMaxLines = 1,
                    subtitle = testText,
                    subtitleMaxLines = 2,
                    cardType = ElCardStyleType.Disabled,
                    icon = {
                        image()
                    },
                    badge = {
                        ElBadge(title = "Warning", state = "warning")
                    }
                )
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    titleMaxLines = 1,
                    subtitle = testText,
                    subtitleMaxLines = 2,
                    cardType = ElCardStyleType.Medium,
                    icon = {
                        image()
                    }
                )
            }
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    titleMaxLines = 1,
                    subtitle = testText,
                    subtitleMaxLines = 2,
                    cardType = ElCardStyleType.Low,
                    icon = {
                        image()
                    }
                )
                ElCardLayout(
                    modifier = Modifier.width(width),
                    title = testText,
                    titleMaxLines = 1,
                    subtitle = testText,
                    subtitleMaxLines = 2,
                    cardType = ElCardStyleType.High,
                    icon = {
                        image()
                    },
                    pill = {
                        ElPill(title = "60% descuento", color = Color.Red)
                    }
                )
            }
        }
    }
}
