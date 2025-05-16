package com.llamasoft.elessa.presentation.components.screens

import androidx.lifecycle.viewModelScope
import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import com.llamasoft.elessa.domain.usecase.GetHomeContainerUseCase
import com.llamasoft.elessa.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeContainerUseCase: GetHomeContainerUseCase,
    private val getHomeComponentsUseCase: GetHomeComponentsUseCase
) : BaseViewModel<HomeUiState>(HomeUiState()) {

    fun loadHome() {
        updateState {
            copy(
                isLoading = true,
                result = null,
                error = null,
                isShimmerActive = true,
                components = null
            )
        }
        viewModelScope.launch {
            val component = getHomeContainerUseCase()
            updateState {
                copy(
                    isLoading = false,
                    result = component,
                    components = component.children?.associateBy(
                        { it.shimmerId },
                        { null }
                    )
                )
            }
            getHomeComponents(component.data?.contentUrl ?: "")
        }
    }

    private fun getHomeComponents(url: String) {
        viewModelScope.launch {
            val homeComponents = getHomeComponentsUseCase(url)
            updateState {
                copy(
                    isLoading = false,
                    isShimmerActive = false,
                    components = homeComponents.children?.associateBy(
                        { it.shimmerId },
                        { it }
                    )
                )
            }
        }
    }
}
