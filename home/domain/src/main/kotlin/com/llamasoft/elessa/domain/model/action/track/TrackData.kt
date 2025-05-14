package com.llamasoft.elessa.domain.model.action.track

import com.llamasoft.elessa.model.sdui.ElActionData

data class TrackData(
    val type: String,
    val id: Int? = 0,
    val path: String?,
    val params: Map<String, String>? = null,
) : ElActionData()
