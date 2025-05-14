package com.llamasoft.elessa.presentation.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.llamasoft.elessa.presentation.components.progress.FadingCircularProgressIndicator
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadHome()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        FadingCircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            isVisible = state.isLoading
        )
        state.result?.let {
            UiViewComponent(component = it)
        }
    }
}
