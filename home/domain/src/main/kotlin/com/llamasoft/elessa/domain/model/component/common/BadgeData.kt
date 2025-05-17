package com.llamasoft.elessa.domain.model.component.common

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class BadgeData(
    @Json(name = "text")
    val text: String? = null
) : Serializable
