package com.llamasoft.elessa.presentation.components.home

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.llamasoft.elessa.presentation.components.navigation.BottomNavItem

const val NAVIGATION_ROUTE_SEARCH = "search"
const val DEEPLINK_SEARCH = "els://search"

fun NavGraphBuilder.searchGraph(navController: NavController) {
    composable(
        route = "deeplink_search",
        deepLinks = listOf(navDeepLink { uriPattern = DEEPLINK_SEARCH })
    ) {
        LaunchedEffect(Unit) {
            navController.navigate(NAVIGATION_ROUTE_SEARCH) {
                popUpTo(BottomNavItem.Home.route) { inclusive = false }
                launchSingleTop = true
            }
        }
        LoadingRedirectPlaceholder()
    }
}
