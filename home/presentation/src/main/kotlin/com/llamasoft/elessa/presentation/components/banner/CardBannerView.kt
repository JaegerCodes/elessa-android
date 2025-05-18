package com.llamasoft.elessa.presentation.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.ui.cardlayout.ElCardLayout
import com.llamasoft.elessa.ui.cardlayout.defaultImageSize
import com.llamasoft.elessa.ui.cardlayout.defaultSubtitleMaxLines
import com.llamasoft.elessa.ui.cardlayout.defaultTitleMaxLines
import com.llamasoft.elessa.ui.cardlayout.toCardSize
import com.llamasoft.elessa.ui.cardlayout.toCardStyleType
import com.llamasoft.elessa.ui.pill.ElPill
import com.llamasoft.elessa.ui.status.badge.ElBadge
import com.llamasoft.elessa.ui.theme.ElessaTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CardBannerView(component: CardBannerComponent) {
    val commandViewModel: ActionCommandViewModel = koinViewModel()

    val data = component.data
    val size = component.properties?.size.toCardSize()

    val networkImage: @Composable (() -> Unit) = {
        AsyncImage(
            model = data?.icon,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(size.defaultImageSize().dp)
                .aspectRatio(0.8f),
            contentScale = ContentScale.Crop
        )
    }

    Box(
        modifier = Modifier
            .padding(bottom = 2.dp)
    ) {
        ElCardLayout(
            titleMaxLines = size.defaultTitleMaxLines(),
            subtitleMaxLines = size.defaultSubtitleMaxLines(),
            title = data?.title,
            subtitle = data?.subtitle,
            cardType = component.properties?.style.toCardStyleType(),
            icon = {
                networkImage()
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
        ) {
            commandViewModel.dispatchAllSuspend(
                component.properties?.actions
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320
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
    val networkImage: @Composable (() -> Unit) = {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black.copy(alpha = 0.2f))
                .size(120.dp)
                .aspectRatio(0.8f),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = data?.icon,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }

    ElessaTheme {
        ElCardLayout(
            titleMaxLines = size.defaultTitleMaxLines(),
            subtitleMaxLines = size.defaultSubtitleMaxLines(),
            title = data?.title,
            subtitle = data?.subtitle,
            cardType = component.properties?.style.toCardStyleType(),
            icon = {
                networkImage()
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
