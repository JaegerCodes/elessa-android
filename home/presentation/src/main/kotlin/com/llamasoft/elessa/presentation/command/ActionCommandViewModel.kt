package com.llamasoft.elessa.presentation.command

import android.util.Log
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.BuildConfig
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.presentation.factory.CommandActionFactory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class ActionCommandViewModel(
    val commandFactory: CommandActionFactory
) : ViewModel() {

    private val _actions = MutableSharedFlow<ElAction>(extraBufferCapacity = 10)
    val actions: SharedFlow<ElAction> = _actions

    private fun dispatch(action: ElAction) {
        _actions.tryEmit(action)
    }

    fun dispatchAll(actions: List<ElAction>?) {
        actions?.forEach { dispatch(it) }
    }

    suspend fun dispatchAllSuspend(actions: List<ElAction>) {
        actions.forEach { _actions.emit(it) }
    }

    fun <T : ElAction> execute(action: T) {
        val handled = commandFactory.getCommandFor(action)?.execute(action) ?: false
        if (!handled && BuildConfig.DEBUG) {
            Log.w("ActionCommands", "Command not handled: ${action.type}")
        }
    }

    inline fun <reified C : CommandAction<*>> getCommand(): C {
        return commandFactory.getInstance<C>()
    }
}
