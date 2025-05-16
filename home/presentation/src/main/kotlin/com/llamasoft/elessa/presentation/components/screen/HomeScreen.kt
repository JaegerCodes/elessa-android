package com.llamasoft.elessa.presentation.components.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.command.SnackbarCommand
import com.llamasoft.elessa.presentation.components.progress.FadingCircularProgressIndicator
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import com.llamasoft.elessa.ui.snackbar.ElSnackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    val actionCommandViewModel: ActionCommandViewModel = koinViewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        launch {
            viewModel.loadHome()
        }
        launch {
            actionCommandViewModel.getCommand<SnackbarCommand>().actionDataFlow
                .collectLatest { data ->
                    snackbarHostState.showSnackbar(data.message)
                }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                ElSnackbar(
                    text = data.visuals.message,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            FadingCircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                isVisible = state.isLoading
            )
            state.result?.let {
                UiViewComponent(component = it)
            }
        }
    }
    ActionCommands()
}
