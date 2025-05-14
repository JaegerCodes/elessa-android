package com.llamasoft.elessa.domain.model.component.topbar

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.buttonwidget.SquaredButtonData
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json

@Keep
data class TopBarComponentData(
    @Json(name = "userTitle")
    val userTitle: String? = null,
    @Json(name = "button")
    val button: SquaredButtonData? = null,
    @Json(name = "notificationButton")
    val notificationButton: SquaredButtonData? = null
) : ElComponentData()
