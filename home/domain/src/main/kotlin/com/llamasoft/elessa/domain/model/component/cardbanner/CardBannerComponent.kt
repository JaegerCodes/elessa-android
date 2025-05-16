package com.llamasoft.elessa.domain.model.component.cardbanner

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.CARD_BANNER_COMPONENT
import com.llamasoft.elessa.domain.model.component.common.BadgeData
import com.llamasoft.elessa.domain.model.component.common.PillData
import com.llamasoft.elessa.model.sdui.ElAccessibility
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.model.sdui.ElComponentData
import com.llamasoft.elessa.model.sdui.ElComponentProperties
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CardBannerComponent(
    @Json(name = "children")
    override val children: List<ElViewComponent>? = null,
    @Json(name = "data")
    override val data: CardBannerData? = null,
    @Json(name = "properties")
    override val properties: CardBannerProperties? = null,
    @Json(name = "shimmerId")
    override val shimmerId: String = ""
) : ElViewComponent(CARD_BANNER_COMPONENT)

@Keep
data class CardBannerProperties(
    @Json(name = "actions")
    val actions: List<ElAction>?,
    @Json(name = "style")
    val style: String? = null,
    @Json(name = "size")
    val size: String? = null,
) : ElComponentProperties()

@Keep
data class CardBannerData(
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "subtitle")
    val subtitle: String? = null,
    @Json(name = "icon")
    val icon: String? = null,
    @Json(name = "pill")
    val pill: PillData? = null,
    @Json(name = "badge")
    val badge: BadgeData? = null,
    @Json(name = "accessibility")
    val accessibility: List<ElAccessibility>? = null
) : ElComponentData()
