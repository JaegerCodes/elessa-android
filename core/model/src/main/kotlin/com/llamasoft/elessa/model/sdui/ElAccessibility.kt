package com.llamasoft.elessa.model.sdui

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class ElAccessibility(
    val type: String? = null,
    val data: ElAccessibilityData? = null
) : Serializable

@Keep
data class ElAccessibilityData(
    val text: String? = null,
    @Json(name = "skipChild")
    val skipChild: Boolean? = null
) : Serializable
