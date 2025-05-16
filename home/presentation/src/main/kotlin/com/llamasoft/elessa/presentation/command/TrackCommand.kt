package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.track.TrackAction
import com.llamasoft.elessa.domain.model.action.track.TrackData

class TrackCommand : FlowCommand<TrackAction, TrackData>() {
    override fun extractData(action: TrackAction): TrackData {
        return action.data
    }
}
