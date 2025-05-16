package com.llamasoft.elessa.domain.model.component.common

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class PillData(
    @Json(name = "color")
    val color: String? = null,
    @Json(name = "text")
    val text: String? = null,
    @Json(name = "textColor")
    val textColor: String? = null,
    @Json(name = "icon")
    val icon: String? = null
)
