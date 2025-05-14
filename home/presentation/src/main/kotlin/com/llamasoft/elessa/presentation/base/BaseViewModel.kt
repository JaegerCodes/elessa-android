package com.llamasoft.elessa.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<VS : BaseViewState>(initialState: VS) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<VS>
        get() = _state

    protected fun updateState(reduce: VS.() -> VS) {
        _state.update(reduce)
    }
}
