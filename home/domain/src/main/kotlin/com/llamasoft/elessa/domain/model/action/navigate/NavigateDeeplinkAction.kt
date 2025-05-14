package com.llamasoft.elessa.domain.model.action.navigate

import androidx.annotation.Keep
import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.NAVIGATE_DEEP_LINK
import com.llamasoft.elessa.model.sdui.ElAction
import com.squareup.moshi.Json

@Keep
data class NavigateDeeplinkAction(
    @Json(name = "data")
    override val data: NavigateDeeplinkData
) : ElAction(NAVIGATE_DEEP_LINK)
