package com.llamasoft.elessa.presentation.components.banner

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerComponent
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerData
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerProperties
import com.llamasoft.elessa.domain.model.component.common.BadgeData
import com.llamasoft.elessa.ui.cardlayout.ElCardLayout
import com.llamasoft.elessa.ui.cardlayout.defaultSubtitleMaxLines
import com.llamasoft.elessa.ui.cardlayout.defaultTitleMaxLines
import com.llamasoft.elessa.ui.cardlayout.toCardSize
import com.llamasoft.elessa.ui.cardlayout.toCardStyleType
import com.llamasoft.elessa.ui.pill.ElPill
import com.llamasoft.elessa.ui.status.badge.ElBadge
import com.llamasoft.elessa.ui.theme.ElessaTheme

@Composable
fun CardBannerView(component: CardBannerComponent) {
    val data = component.data
    val size = component.properties?.size.toCardSize()
    val image: @Composable () -> Unit = {
        AsyncImage(
            model = data?.icon,
            contentDescription = null,
            modifier = Modifier
                .defaultMinSize(64.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }

    ElCardLayout(
        titleMaxLines = size.defaultTitleMaxLines(),
        subtitleMaxLines = size.defaultSubtitleMaxLines(),
        title = data?.title,
        subtitle = data?.subtitle,
        cardType = component.properties?.style.toCardStyleType(),
        icon = {
            image()
        },
        pill = {
            data?.pill?.let { pill ->
                ElPill(
                    title = pill.text.orEmpty(),
                    color = Color.Red
                )
            }
        },
        badge = {
            data?.badge?.let { badge ->
                ElBadge(title = badge.text.orEmpty(), state = "warning")
            }
        },
    )
}

@Preview(
    showBackground = true,
    widthDp = 290
)
@Composable
fun PreviewCardBannerView() {
    val component = CardBannerComponent(
        data = CardBannerData(
            title = "Promoción especial",
            subtitle = "Aprovecha hasta el 50% de descuento",
            icon = "https://placekitten.com/200/200",
            pill = null,
            badge = BadgeData(
                text = "Nuevo"
            )
        ),
        properties = CardBannerProperties(
            actions = null,
            style = "high",
            size = "XL"
        )
    )
    val data = component.data
    val size = component.properties?.size.toCardSize()

    val image: @Composable () -> Unit = {
        AsyncImage(
            model = data?.icon,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }

    ElessaTheme {
        ElCardLayout(
            titleMaxLines = size.defaultTitleMaxLines(),
            subtitleMaxLines = size.defaultSubtitleMaxLines(),
            title = data?.title,
            subtitle = data?.subtitle,
            cardType = component.properties?.style.toCardStyleType(),
            icon = {
                image()
            },
            pill = {
                data?.pill?.let { pill ->
                    ElPill(
                        title = pill.text.orEmpty(),
                        color = Color.Red
                    )
                }
            },
            badge = {
                data?.badge?.let { badge ->
                    ElBadge(title = badge.text.orEmpty(), state = "warning")
                }
            },
        )
    }
}
