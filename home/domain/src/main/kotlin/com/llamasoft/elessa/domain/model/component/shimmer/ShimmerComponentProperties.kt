package com.llamasoft.elessa.domain.model.component.shimmer

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.BaseComponentProperties
import com.squareup.moshi.Json

@Keep
data class ShimmerComponentProperties(
    @Json(name = "showShimmer")
    val showShimmer: Boolean = true
): BaseComponentProperties()
