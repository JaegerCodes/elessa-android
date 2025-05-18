package com.llamasoft.elessa.presentation.components.carousel

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.carousel.CarouselComponent
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import com.llamasoft.elessa.ui.corrousel.ElCarousel

@Composable
fun CarouselView(
    component: CarouselComponent
) {
    val children = component.children
    if (children.isNullOrEmpty()) return

    when (children.size) {
        1 -> {
            UiViewComponent(component = children.first())
        }
        else -> {
            val pagerState = rememberPagerState { children.size }
            ElCarousel(
                pageContent = { index ->
                    UiViewComponent(component = children[index])
                },
                showPager = component.properties?.showPager ?: false,
                carouselState = pagerState
            )
        }
    }
}
