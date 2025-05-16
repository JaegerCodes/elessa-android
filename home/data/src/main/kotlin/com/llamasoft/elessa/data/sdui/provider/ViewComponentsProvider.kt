package com.llamasoft.elessa.data.sdui.provider

import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.CARD_BANNER_COMPONENT
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.CARD_BANNER_SHIMMER_COMPONENT
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.HOME_CONTAINER
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.SECTION_TITLE
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.SECTION_TITLE_SHIMMER_COMPONENT
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_COMPONENT
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_SHIMMER_COMPONENT
import com.llamasoft.elessa.domain.model.component.cardbanner.CardBannerComponent
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponent
import com.llamasoft.elessa.domain.model.component.shimmer.CardBannerShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.SectionTitleShimmerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.model.sdui.ComponentAdapterProvider
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.model.sdui.UnknownComponent
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

internal class ComponentAdapterProviderImpl : ComponentAdapterProvider {
    override fun provide(factory: PolymorphicJsonAdapterFactory<ElViewComponent>): PolymorphicJsonAdapterFactory<ElViewComponent> {
        return factory
            .withDefaultValue(UnknownComponent)
            .withSubtype(HomeContainerComponent::class.java, HOME_CONTAINER)
            .withSubtype(TopBarComponent::class.java, TOP_BAR_COMPONENT)
            .withSubtype(TopBarShimmerComponent::class.java, TOP_BAR_SHIMMER_COMPONENT)
            .withSubtype(SectionTitleComponent::class.java, SECTION_TITLE)
            .withSubtype(SectionTitleShimmerComponent::class.java, SECTION_TITLE_SHIMMER_COMPONENT)
            .withSubtype(CardBannerComponent::class.java, CARD_BANNER_COMPONENT)
            .withSubtype(CardBannerShimmerComponent::class.java, CARD_BANNER_SHIMMER_COMPONENT)
    }
}
