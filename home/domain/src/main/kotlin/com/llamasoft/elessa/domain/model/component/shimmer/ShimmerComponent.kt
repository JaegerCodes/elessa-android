package com.llamasoft.elessa.domain.model.component.shimmer

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_SHIMMER_COMPONENT
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
sealed class ShimmerComponent(type: String): ElViewComponent(type)

@Keep
@JsonClass(generateAdapter = true)
data class TopBarShimmerComponent(
    @Json(name = "shimmerId")
    override val shimmerId: String = "",
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: ElComponentData? = null,
    @Json(name = "properties")
    override val properties: ShimmerComponentProperties? = null
) : ShimmerComponent(TOP_BAR_SHIMMER_COMPONENT)
