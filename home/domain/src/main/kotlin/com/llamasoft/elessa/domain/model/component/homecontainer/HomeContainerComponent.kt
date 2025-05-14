package com.llamasoft.elessa.domain.model.component.homecontainer

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.HOME_CONTAINER
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.squareup.moshi.Json

@Keep
data class HomeContainerComponent(
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: HomeContainerComponentData? = null,
    @Json(name = "properties")
    override val properties: HomeContainerProperties? = null
) : ElViewComponent(HOME_CONTAINER)
