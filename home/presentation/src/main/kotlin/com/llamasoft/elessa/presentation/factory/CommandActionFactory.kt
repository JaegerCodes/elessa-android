package com.llamasoft.elessa.presentation.factory

import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkAction
import com.llamasoft.elessa.domain.model.action.snackbar.ShowSnackbarAction
import com.llamasoft.elessa.domain.model.action.track.TrackAction
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.presentation.command.CommandAction
import com.llamasoft.elessa.presentation.command.NavigateCommand
import com.llamasoft.elessa.presentation.command.SnackbarCommand
import com.llamasoft.elessa.presentation.command.TrackCommand
import kotlin.reflect.KClass

class CommandActionFactory {

    private val commandMap: Map<KClass<out ElAction>, CommandAction<out ElAction>> = buildMap {
        register(NavigateDeeplinkAction::class, NavigateCommand())
        register(TrackAction::class, TrackCommand())
        register(ShowSnackbarAction::class, SnackbarCommand())
    }

    private val instanceMap: Map<KClass<out CommandAction<*>>, CommandAction<*>> = commandMap
        .values.associateBy { it::class }

    @Suppress("UNCHECKED_CAST")
    fun <T : ElAction> getCommandFor(action: T): CommandAction<T>? {
        return commandMap[action::class] as? CommandAction<T>
    }

    private fun <T : ElAction> MutableMap<KClass<out ElAction>, CommandAction<out ElAction>>.register(
        kClass: KClass<T>,
        command: CommandAction<T>
    ) {
        this[kClass] = command
    }

    @Suppress("UNCHECKED_CAST")
    fun <C : CommandAction<*>> getInstance(clazz: KClass<C>): C? {
        return instanceMap[clazz] as? C
    }
    inline fun <reified C : CommandAction<*>> getInstance(): C {
        return getInstance(C::class) ?: error("Command ${C::class.simpleName} not found")
    }
}
