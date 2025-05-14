package com.llamasoft.elessa.presentation.components.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HomeViewModel(
    private val getHomeComponents: GetHomeComponentsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    fun loadHome() {
        viewModelScope.launch {
            try {
                val component = getHomeComponents()
                _uiState.value = HomeUiState.Success(component)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
