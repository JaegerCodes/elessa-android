package com.llamasoft.elessa.presentation.components.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.command.SnackbarCommand
import com.llamasoft.elessa.presentation.components.swipe.SwipeToRefreshBox
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import com.llamasoft.elessa.ui.snackbar.ElSnackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val actionCommandViewModel: ActionCommandViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()
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
        modifier = Modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                ElSnackbar(
                    text = data.visuals.message,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        },
        contentWindowInsets = WindowInsets(0.dp, 2.dp, 0.dp, 0.dp)
    ) { padding ->
        SwipeToRefreshBox(
            isRefreshing = state.isLoading,
            onRefresh = { viewModel.loadHome() },
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            state.result?.let {
                UiViewComponent(component = it)
            }
        }
    }
    ActionCommands()
}
