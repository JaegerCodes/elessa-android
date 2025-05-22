package com.llamasoft.elessa.presentation.components.screen

import androidx.lifecycle.viewModelScope
import com.llamasoft.elessa.domain.model.status.Status
import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import com.llamasoft.elessa.domain.usecase.GetHomeContainerUseCase
import com.llamasoft.elessa.model.result.onResult
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
            val componentResult = getHomeContainerUseCase()
            componentResult.onResult(
                onSuccess = { component ->
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
                    component.data?.contentUrl?.let { url ->
                        getHomeComponents(url)
                    }
                },
                onFailure = {
                    updateState {
                        copy(
                            isLoading = false,
                            error = Status.SERVER_ERROR,
                            isShimmerActive = false
                        )
                    }
                }
            )
        }
    }

    private fun getHomeComponents(url: String) {
        viewModelScope.launch {
            val homeComponentsResult = getHomeComponentsUseCase(url)
            homeComponentsResult.onResult(
                onSuccess = { homeComponents ->
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
                },
                onFailure = {
                    updateState {
                        copy(
                            isLoading = false,
                            isShimmerActive = false,
                            error = Status.SERVER_ERROR
                        )
                    }
                }
            )
        }
    }
}
