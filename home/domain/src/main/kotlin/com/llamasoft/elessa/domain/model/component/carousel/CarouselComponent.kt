package com.llamasoft.elessa.domain.model.component.carousel

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.CAROUSEL_COMPONENT
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.llamasoft.elessa.model.sdui.ElComponentProperties
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CarouselComponent(
    @Json(name = "shimmerId")
    override val shimmerId: String = "",
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: ElComponentData? = null,
    @Json(name = "properties")
    override val properties: CarouselProperties? = null
) : ElViewComponent(CAROUSEL_COMPONENT)

@Keep
data class CarouselProperties(
    @Json(name = "showPager")
    val showPager: Boolean? = null,
    @Json(name = "scrollIsCompleted")
    val scrollIsCompleted: Boolean? = null,
    @Json(name = "autoScrollProperties")
    val autoScrollProperties: AutoScrollProperties? = null,
): ElComponentProperties()

@Keep
data class AutoScrollProperties(
    @Json(name = "isEnabled")
    val isEnabled: Boolean? = null,
    @Json(name = "duration")
    val duration: Int? = null,
    @Json(name = "autoScrollDirection")
    val userInteractionDuration: Int? = null,
)
