package com.llamasoft.elessa.presentation.command

import androidx.lifecycle.ViewModel
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.presentation.factory.CommandActionFactory

class ActionCommandViewModel(
    val commandFactory: CommandActionFactory
) : ViewModel() {

    fun <T : ElAction> execute(action: T): Boolean {
        return commandFactory.getCommandFor(action)?.execute(action) ?: false
    }

    inline fun <reified C : CommandAction<*>> getCommand(): C {
        return commandFactory.getInstance<C>()
    }
}
