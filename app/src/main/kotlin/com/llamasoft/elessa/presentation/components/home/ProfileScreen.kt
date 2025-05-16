package com.llamasoft.elessa.presentation.components.home

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink

const val NAVIGATION_ROUTE_PROFILE = "profile"
const val DEEPLINK_PROFILE = "els://profile"

fun NavGraphBuilder.profileGraph(navController: NavController) {
    composable(
        route = "deeplink_home",
        deepLinks = listOf(navDeepLink { uriPattern = DEEPLINK_PROFILE })
    ) {
        LaunchedEffect(Unit) {
            navController.navigate(NAVIGATION_ROUTE_PROFILE) {
                popUpTo(NAVIGATION_ROUTE_PROFILE) { inclusive = false }
                launchSingleTop = true
            }
        }
        LoadingRedirectPlaceholder()
    }
}
