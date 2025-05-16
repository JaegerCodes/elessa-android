package com.llamasoft.elessa.presentation.components.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.llamasoft.elessa.navigation.LocalNavController
import com.llamasoft.elessa.presentation.components.navigation.BottomNavItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = BottomNavItem.entries
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEach { item ->
                        BuildBottomNavItem(currentRoute, item, navController)
                    }
                }
            }
        ) { padding ->

            BackHandler(enabled = currentRoute != BottomNavItem.Home.route) {
                if (navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }

            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Home.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(NAVIGATION_ROUTE_HOME) {
                    HomeScreen()
                }
                composable(NAVIGATION_ROUTE_SEARCH) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text("Search")
                    }
                }
                composable(NAVIGATION_ROUTE_PROFILE) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text("Profile")
                    }
                }

                homeGraph(navController)

                searchGraph(navController)

                profileGraph(navController)

                composable(
                    route = "deeplink_user",
                    deepLinks = listOf(navDeepLink { uriPattern = "els://user" })
                ) {
                    LaunchedEffect(Unit) {
                        navController.navigate("not_found") {
                            popUpTo(BottomNavItem.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
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
    }
}

@Composable
private fun RowScope.BuildBottomNavItem(
    currentRoute: String?,
    item: BottomNavItem,
    navController: NavHostController
) {
    NavigationBarItem(
        selected = currentRoute == item.route || currentRoute?.contains(item.route) == true,
        onClick = {
            if (currentRoute != item.route) {
                navController.navigate(item.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = false
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        icon = { Icon(item.icon, contentDescription = item.label) },
        label = { Text(item.label) }
    )
}
