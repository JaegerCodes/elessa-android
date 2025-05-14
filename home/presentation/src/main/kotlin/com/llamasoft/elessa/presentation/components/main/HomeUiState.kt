package com.llamasoft.elessa.presentation.components.main

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val component: HomeContainerComponent) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
