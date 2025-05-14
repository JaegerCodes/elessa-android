package com.llamasoft.elessa.presentation.factory

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.presentation.components.container.HomeContainerViewComponent
import com.llamasoft.elessa.presentation.components.topbar.TopBarShimmerViewComponent
import com.llamasoft.elessa.presentation.components.topbar.TopBarViewComponent
import kotlin.reflect.KClass

class ViewComponentsFactory {
    private val componentMap: Map<KClass<out ElViewComponent>, (ElViewComponent) -> ViewComponent> = buildMap {
        register<HomeContainerComponent> { HomeContainerViewComponent(it) }
        register<TopBarShimmerComponent> { TopBarShimmerViewComponent(it) }
        register<TopBarComponent> { TopBarViewComponent(it) }
    }

    fun create(component: ElViewComponent): ViewComponent? {
        return componentMap[component::class]?.invoke(component)
    }

    private inline fun <reified T : ElViewComponent> MutableMap<KClass<out ElViewComponent>, (ElViewComponent) -> ViewComponent>.register(
        noinline factory: (T) -> ViewComponent
    ) {
        this[T::class] = { factory(it as T) }
    }
}
