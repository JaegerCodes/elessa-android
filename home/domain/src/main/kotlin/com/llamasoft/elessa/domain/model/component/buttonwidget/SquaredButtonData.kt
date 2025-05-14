package com.llamasoft.elessa.domain.model.component.buttonwidget

import androidx.annotation.Keep
import com.llamasoft.elessa.model.sdui.ElAccessibility
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class SquaredButtonData(
    @Json(name = "label")
    val label: String? = null,
    @Json(name = "enabled")
    val enabled: Boolean = true,
    @Json(name = "actions")
    val actions: List<ElAction>?,
    @Json(name = "unreadNotifications")
    val unreadNotifications: Int = 0,
    @Json(name = "accessibility")
    val accessibility: List<ElAccessibility>? = null,
    @Json(name = "coachMark")
    val coachMark: CoachMarkButtonData? = null
) : Serializable, ElComponentData()

@Keep
data class CoachMarkButtonData(
    @Json(name = "message")
    val message: String? = null,
    @Json(name = "coachMarkId")
    val coachMarkId: String,
    @Json(name = "accessibility")
    val accessibility: List<ElAccessibility>? = null,
    @Json(name = "closeButton")
    val closeButton: CoachMarkCloseButtonData? = null
) : Serializable

@Keep
data class CoachMarkCloseButtonData(
    @Json(name = "text")
    val text: String? = null,
    @Json(name = "actions")
    val actions: List<ElAction>?
) : Serializable
