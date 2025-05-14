package com.llamasoft.elessa.presentation.components.home

import com.llamasoft.elessa.domain.model.status.Status
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.presentation.base.BaseViewState

data class HomeUiState(
    val isLoading: Boolean = false,
    val result: ElViewComponent? = null,
    val error: Status? = null,
    val isShimmerActive: Boolean = true,
    val components: Map<String, ElViewComponent?>? = null,
): BaseViewState
