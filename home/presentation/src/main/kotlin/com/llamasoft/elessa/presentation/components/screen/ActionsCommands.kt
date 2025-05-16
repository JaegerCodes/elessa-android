package com.llamasoft.elessa.presentation.components.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.llamasoft.elessa.navigation.LocalNavController
import com.llamasoft.elessa.navigation.safeNavigate
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.command.NavigateCommand
import com.llamasoft.elessa.presentation.command.TrackCommand
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActionCommands() {
    val viewModel: ActionCommandViewModel = koinViewModel()
    val navController = LocalNavController.current

    LaunchedEffect(Unit) {
        viewModel.actions.collectLatest { action ->
            viewModel.execute(action)
        }
    }

    LaunchedEffect(Unit) {
        launch {
            viewModel.getCommand<NavigateCommand>().actionDataFlow
                .collectLatest { data ->
                    navController.safeNavigate(data.path)
                }
        }

        launch {
            viewModel.getCommand<TrackCommand>().actionDataFlow
                .collectLatest { data ->
                    Log.w("ActionCommands", "Tracking event: ${data.path}")
                }
        }
    }
}
