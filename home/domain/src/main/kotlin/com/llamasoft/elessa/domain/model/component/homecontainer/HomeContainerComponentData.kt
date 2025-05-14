package com.llamasoft.elessa.domain.model.component.homecontainer

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json

@Keep
data class HomeContainerComponentData(
    @Json(name = "contentUrl")
    val contentUrl: String? = null
) : ElComponentData()
