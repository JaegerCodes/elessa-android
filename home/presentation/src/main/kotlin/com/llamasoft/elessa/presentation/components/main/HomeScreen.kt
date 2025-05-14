package com.llamasoft.elessa.presentation.components.main

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is HomeUiState.Loading -> CircularProgressIndicator()
        is HomeUiState.Error -> {
            Text("Error: ${(state as HomeUiState.Error).message}")
        }
        is HomeUiState.Success -> {
            val component = (state as HomeUiState.Success).component
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadHome()
    }
}
