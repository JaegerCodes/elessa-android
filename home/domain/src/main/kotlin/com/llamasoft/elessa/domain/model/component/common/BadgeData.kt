package com.llamasoft.elessa.domain.model.component.common

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class BadgeData(
    @Json(name = "color")
    val color: String? = null,
    @Json(name = "text")
    val text: String? = null,
    @Json(name = "textColor")
    val textColor: String? = null
) : Serializable
