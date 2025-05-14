package com.llamasoft.elessa.domain.model.action.navigate

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.ElActionData
import com.squareup.moshi.Json

@Keep
data class NavigateDeeplinkData(
    @Json(name = "path")
    val path: String
) : ElActionData()
