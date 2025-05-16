package com.llamasoft.elessa.presentation.components.banner

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerComponent
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerData
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerProperties
import com.llamasoft.elessa.ui.cardlayout.ElCardLayout
import com.llamasoft.elessa.ui.cardlayout.toCardSize
import com.llamasoft.elessa.ui.cardlayout.toCardStyleType
import com.llamasoft.elessa.ui.theme.ElessaTheme

@Composable
fun CardBannerView(component: CardBannerComponent) {
    val data = component.data

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

    ElCardLayout(
        size = component.properties?.size.toCardSize(),
        modifier = Modifier.width(280.dp),
        title = data?.title,
        subtitle = data?.subtitle,
        cardType = component.properties?.style.toCardStyleType(),
        icon = {
            image()
        },
        pill = {
            //ElPill(title = "60% descuento", color = Color.Red)
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewCardBannerView() {
    val component = CardBannerComponent(
        data = CardBannerData(
            title = "Promoción especial",
            subtitle = "Aprovecha hasta el 50% de descuento",
            icon = "https://placekitten.com/200/200"
        ),
        properties = CardBannerProperties(
            actions = null,
            style = "Medium",
            size = "M"
        )
    )

    ElessaTheme {
        CardBannerView(component = component)
    }
}
