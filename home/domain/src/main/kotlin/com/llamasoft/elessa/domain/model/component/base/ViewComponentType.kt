package com.llamasoft.elessa.domain.model.component.base

import androidx.annotation.Keep
import androidx.annotation.StringDef

@Keep
@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ViewComponentType.TOP_BAR_SHIMMER_COMPONENT,
    ViewComponentType.TOP_BAR_COMPONENT,
    ViewComponentType.HOME_CONTAINER
)
annotation class ViewComponentType {
    companion object {
        const val TOP_BAR_SHIMMER_COMPONENT = "TopBarShimmerWidget"
        const val TOP_BAR_COMPONENT = "TopBarWidget"
        const val HOME_CONTAINER = "HomeContainer"
    }
}
