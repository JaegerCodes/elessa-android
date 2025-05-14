package com.llamasoft.elessa.data.sdui.provider

import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.HOME_CONTAINER
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_COMPONENT
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_SHIMMER_COMPONENT
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
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
    }
}
