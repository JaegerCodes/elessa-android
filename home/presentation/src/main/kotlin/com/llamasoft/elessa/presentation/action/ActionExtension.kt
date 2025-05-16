package com.llamasoft.elessa.presentation.action

import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel

fun ElAction.executeWith(viewModel: ActionCommandViewModel): Boolean {
    return viewModel.execute(this)
}

fun List<ElAction>.executeAll(viewModel: ActionCommandViewModel): List<Boolean> {
    return map { it.executeWith(viewModel) }
}
