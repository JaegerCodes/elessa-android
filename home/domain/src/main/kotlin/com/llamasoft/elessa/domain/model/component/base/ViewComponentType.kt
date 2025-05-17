package com.llamasoft.elessa.domain.model.component.base

import androidx.annotation.Keep
import androidx.annotation.StringDef

@Keep
@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ViewComponentType.TOP_BAR_SHIMMER_COMPONENT,
    ViewComponentType.TOP_BAR_COMPONENT,
    ViewComponentType.HOME_CONTAINER,
    ViewComponentType.SECTION_TITLE,
    ViewComponentType.SECTION_TITLE_SHIMMER_COMPONENT,
    ViewComponentType.CARD_BANNER_COMPONENT,
    ViewComponentType.CARD_BANNER_XL_SHIMMER_COMPONENT,
    ViewComponentType.CARD_BANNER_M_SHIMMER_COMPONENT
)
annotation class ViewComponentType {
    companion object {
        const val TOP_BAR_COMPONENT = "TopBarWidget"
        const val TOP_BAR_SHIMMER_COMPONENT = "TopBarShimmerWidget"
        const val HOME_CONTAINER = "HomeContainer"
        const val SECTION_TITLE = "SectionTitle"
        const val SECTION_TITLE_SHIMMER_COMPONENT = "SectionTitleShimmerWidget"
        const val CARD_BANNER_COMPONENT = "CardBannerWidget"
        const val CARD_BANNER_XL_SHIMMER_COMPONENT = "CardBannerXLShimmerWidget"
        const val CARD_BANNER_M_SHIMMER_COMPONENT = "CardBannerMShimmerWidget"
    }
}
