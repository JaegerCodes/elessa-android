package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.track.TrackAction

class TrackCommand: CommandAction<TrackAction> {
    override fun execute(action: TrackAction): Boolean {
        return true
    }
}
