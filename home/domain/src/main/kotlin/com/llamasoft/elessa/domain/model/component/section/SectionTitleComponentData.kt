package com.llamasoft.elessa.domain.model.component.section

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.ElAccessibility
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json

@Keep
data class SectionTitleComponentData(
    @Json(name = "text")
    val text: String? = null,
    @Json(name = "accessibility")
    val accessibility: List<ElAccessibility>? = null
) : ElComponentData()
