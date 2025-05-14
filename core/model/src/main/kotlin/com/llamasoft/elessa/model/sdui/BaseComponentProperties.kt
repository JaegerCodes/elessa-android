package com.llamasoft.elessa.model.sdui

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class BaseComponentProperties(
    @Json(name = "initActions")
    var initActions: List<ElAction>? = null
) : ElComponentProperties()
