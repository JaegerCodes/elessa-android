package com.llamasoft.elessa.presentation.components.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink

const val NAVIGATION_ROUTE_HOME = "home"
const val DEEPLINK_HOME = "els://home"

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(
        route = "deeplink_home",
        deepLinks = listOf(navDeepLink { uriPattern = DEEPLINK_HOME })
    ) {
        LaunchedEffect(Unit) {
            navController.navigate(NAVIGATION_ROUTE_HOME) {
                popUpTo(NAVIGATION_ROUTE_HOME) { inclusive = false }
                launchSingleTop = true
            }
        }
        LoadingRedirectPlaceholder()
    }
}

@Composable
private fun LoadingRedirectPlaceholder() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}