package com.llamasoft.elessa.presentation.components.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.llamasoft.elessa.presentation.components.screens.HomeViewModel
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun ViewOrShimmer(
    shimmerId: String,
    shimmerContent: @Composable () -> Unit
) {
    val viewModel: HomeViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val viewComponent = state.components?.get(shimmerId)

    if (viewComponent == null && state.isShimmerActive) {
        shimmerContent()
    } else {
        UiViewComponent(component = viewComponent)
    }
}
