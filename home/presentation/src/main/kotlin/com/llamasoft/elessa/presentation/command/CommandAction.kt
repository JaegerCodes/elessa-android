package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.model.sdui.ElAction
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

interface CommandAction<T : ElAction> {
    fun execute(action: T): Boolean
}

abstract class FlowCommand<T : ElAction, D> : CommandAction<T> {
    abstract fun extractData(action: T): D

    private val _actionDataFlow = MutableSharedFlow<D>(extraBufferCapacity = 1)
    val actionDataFlow: SharedFlow<D> = _actionDataFlow

    override fun execute(action: T): Boolean {
        return _actionDataFlow.tryEmit(extractData(action))
    }
}
