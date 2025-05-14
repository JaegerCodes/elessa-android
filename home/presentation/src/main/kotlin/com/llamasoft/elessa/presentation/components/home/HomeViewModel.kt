package com.llamasoft.elessa.presentation.components.home

import androidx.lifecycle.viewModelScope
import com.llamasoft.elessa.domain.model.status.Status
import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import com.llamasoft.elessa.domain.usecase.GetHomeContainerUseCase
import com.llamasoft.elessa.model.sdui.ElViewComponent
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
            try {
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
            } catch (e: Exception) {
                updateState {
                    copy(
                        isLoading = false,
                        error = Status.SERVER_ERROR
                    )
                }
            }
        }
    }

    private fun getHomeComponents(url: String) {
        viewModelScope.launch {
            try {
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
            } catch (e: Exception) {
                updateState {
                    copy(
                        isLoading = false,
                        error = Status.SERVER_ERROR
                    )
                }
            }
        }
    }
}
