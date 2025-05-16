package com.llamasoft.elessa.domain.model.component.section

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.SECTION_TITLE
import com.llamasoft.elessa.model.sdui.ElComponentProperties
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class SectionTitleComponent(
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: SectionTitleComponentData? = null,
    @Json(name = "properties")
    override val properties: ElComponentProperties? = null,
    @Json(name = "shimmerId")
    override val shimmerId: String = ""
) : ElViewComponent(SECTION_TITLE)
