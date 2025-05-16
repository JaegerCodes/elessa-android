package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.snackbar.ShowSnackbarAction
import com.llamasoft.elessa.domain.model.action.snackbar.ShowSnackbarData

class SnackbarCommand : FlowCommand<ShowSnackbarAction, ShowSnackbarData>() {
    override fun extractData(action: ShowSnackbarAction): ShowSnackbarData {
        return action.data
    }
}
