package com.llamasoft.elessa.presentation.components.carousel

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.carousel.CarouselComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent

data class CarouselViewComponent(
    override val component: CarouselComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        CarouselView(component = component)
    }
}
