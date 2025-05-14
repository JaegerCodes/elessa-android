package com.llamasoft.elessa.domain.model.action.snackbar

import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.SHOW_SNACKBAR_ACTION
import com.llamasoft.elessa.model.sdui.ElAction

data class ShowSnackbarAction(
    override val data: ShowSnackbarData
) : ElAction(SHOW_SNACKBAR_ACTION)
