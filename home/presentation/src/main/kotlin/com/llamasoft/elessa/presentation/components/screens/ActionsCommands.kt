package com.llamasoft.elessa.presentation.components.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.airbnb.lottie.BuildConfig
import com.llamasoft.elessa.navigation.LocalNavController
import com.llamasoft.elessa.navigation.safeNavigate
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.command.NavigateCommand
import com.llamasoft.elessa.presentation.command.SnackbarCommand
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
            viewModel.execute(action).let { handled ->
                if (!handled && BuildConfig.DEBUG) {
                    Log.w("ActionCommands", "Command not handled: ${action.type}")
                }
            }
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
            viewModel.getCommand<SnackbarCommand>().actionDataFlow
                .collectLatest { data ->

                }
        }

        launch {
            viewModel.getCommand<TrackCommand>().actionDataFlow
                .collectLatest { data ->
                    // Handle tracking event
                    Log.w("ActionCommands", "Tracking event: ${data.path}")
                }
        }
    }
}
