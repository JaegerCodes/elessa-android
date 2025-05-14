package com.llamasoft.elessa.model.sdui

import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

interface ComponentAdapterProvider {
    fun provide(
        factory: PolymorphicJsonAdapterFactory<ElViewComponent>
    ): PolymorphicJsonAdapterFactory<ElViewComponent>
}

interface ActionAdapterProvider {
    fun provide(
        factory: PolymorphicJsonAdapterFactory<ElAction>
    ): PolymorphicJsonAdapterFactory<ElAction>
}
