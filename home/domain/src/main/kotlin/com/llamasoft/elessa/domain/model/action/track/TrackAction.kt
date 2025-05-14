package com.llamasoft.elessa.domain.model.action.track

import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.TRACK
import com.llamasoft.elessa.model.sdui.ElAction

data class TrackAction(
    override val data: TrackData
) : ElAction(TRACK)
