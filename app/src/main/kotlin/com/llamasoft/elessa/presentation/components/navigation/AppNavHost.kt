package com.llamasoft.elessa.presentation.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.llamasoft.elessa.checkout.presentation.screen.CheckoutScreen
import com.llamasoft.elessa.notifications.presentation.screen.NotificationsScreen
import com.llamasoft.elessa.presentation.components.screen.DEEPLINK_HOME
import com.llamasoft.elessa.presentation.components.screen.HomeScreen
import com.llamasoft.elessa.presentation.components.screen.NAVIGATION_ROUTE_HOME

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = "home"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = NAVIGATION_ROUTE_HOME,
            deepLinks = listOf(navDeepLink { uriPattern = DEEPLINK_HOME })
        ) {
            HomeScreen()
        }
        composable(
            route = "checkout",
            deepLinks = listOf(navDeepLink { uriPattern = "els://checkout" })
        ) {
            CheckoutScreen()
        }
        composable(
            route = "notifications",
            deepLinks = listOf(navDeepLink { uriPattern = "els://notifications" })
        ) {
            NotificationsScreen()
        }

        composable(
            route = "deeplink_user",
            deepLinks = listOf(navDeepLink { uriPattern = "els://user" })
        ) {
            LoadingRedirectPlaceholder()
        }

        composable("not_found") {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Not Found",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}
