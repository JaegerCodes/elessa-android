package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.snackbar.ShowSnackbarAction

class SnackbarCommand: CommandAction<ShowSnackbarAction> {
    override fun execute(action: ShowSnackbarAction): Boolean {
        return true
    }
}
