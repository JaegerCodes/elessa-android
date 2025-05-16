package com.llamasoft.elessa.presentation.components.banner

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent

data class CardBannerViewComponent(
    val component: CardBannerComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        CardBannerView(component = component)
    }
}
