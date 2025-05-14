package com.llamasoft.elessa.domain.model.component.topbar

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.TOP_BAR_COMPONENT
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.model.sdui.ElComponentProperties
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class TopBarComponent(
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: TopBarComponentData? = null,
    @Json(name = "properties")
    override val properties: ElComponentProperties? = null,
    @Json(name = "shimmerId")
    override val shimmerId: String = ""
) : ElViewComponent(TOP_BAR_COMPONENT)
