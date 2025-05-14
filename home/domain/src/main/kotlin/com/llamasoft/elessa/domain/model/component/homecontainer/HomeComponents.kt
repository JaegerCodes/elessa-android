package com.llamasoft.elessa.domain.model.component.homecontainer

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class HomeComponents(
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: ElComponentData? = null,
    @Json(name = "properties")
    override val properties: HomeContainerProperties? = null
) : ElViewComponent("HOME_COMPONENTS")

