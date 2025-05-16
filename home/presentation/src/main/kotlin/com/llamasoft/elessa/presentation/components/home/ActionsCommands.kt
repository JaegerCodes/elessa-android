package com.llamasoft.elessa.presentation.components.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.llamasoft.elessa.navigation.LocalNavController
import com.llamasoft.elessa.navigation.safeNavigate
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.command.NavigateCommand
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActionCommands() {
    val viewModel: ActionCommandViewModel = koinViewModel()
    val navController = LocalNavController.current

    LaunchedEffect(Unit) {
        viewModel.getCommand<NavigateCommand>().actionDataFlow
            .collectLatest { data ->
                navController.safeNavigate(data.path)
            }
    }
}
