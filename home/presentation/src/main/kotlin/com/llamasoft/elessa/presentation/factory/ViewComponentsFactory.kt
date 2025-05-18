package com.llamasoft.elessa.presentation.factory

import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerComponent
import com.llamasoft.elessa.domain.model.component.carousel.CarouselComponent
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponent
import com.llamasoft.elessa.domain.model.component.shimmer.CardBannerMShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.CardBannerXLShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.CarouselShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.SectionTitleShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.presentation.components.banner.CardBannerMShimmerViewComponent
import com.llamasoft.elessa.presentation.components.banner.CardBannerViewComponent
import com.llamasoft.elessa.presentation.components.banner.CardBannerXLShimmerViewComponent
import com.llamasoft.elessa.presentation.components.carousel.CarouselShimmerViewComponent
import com.llamasoft.elessa.presentation.components.carousel.CarouselViewComponent
import com.llamasoft.elessa.presentation.components.container.HomeContainerViewComponent
import com.llamasoft.elessa.presentation.components.section.SectionTitleShimmerViewComponent
import com.llamasoft.elessa.presentation.components.section.SectionTitleViewComponent
import com.llamasoft.elessa.presentation.components.topbar.TopBarShimmerViewComponent
import com.llamasoft.elessa.presentation.components.topbar.TopBarViewComponent
import kotlin.reflect.KClass

class ViewComponentsFactory {
    private val componentMap: Map<KClass<out ElViewComponent>, (ElViewComponent) -> ViewComponent> = buildMap {
        register<HomeContainerComponent> { HomeContainerViewComponent(it) }
        register<TopBarShimmerComponent> { TopBarShimmerViewComponent(it) }
        register<TopBarComponent> { TopBarViewComponent(it) }
        register<SectionTitleComponent> { SectionTitleViewComponent(it) }
        register<SectionTitleShimmerComponent> { SectionTitleShimmerViewComponent(it) }
        register<CardBannerXLShimmerComponent> { CardBannerXLShimmerViewComponent(it) }
        register<CardBannerMShimmerComponent> { CardBannerMShimmerViewComponent(it) }
        register<CardBannerComponent> { CardBannerViewComponent(it) }
        register<CarouselComponent> { CarouselViewComponent(it) }
        register<CarouselShimmerComponent> { CarouselShimmerViewComponent(it) }
    }

    fun create(component: ElViewComponent): ViewComponent? {
        return componentMap[component::class]?.invoke(component)
    }

    private inline fun <reified T : ElViewComponent> MutableMap<
        KClass<out ElViewComponent>, (ElViewComponent) -> ViewComponent
    >.register(
        noinline factory: (T) -> ViewComponent
    ) {
        this[T::class] = { factory(it as T) }
    }
}
