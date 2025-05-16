package com.llamasoft.elessa.presentation.components.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.llamasoft.elessa.navigation.LocalNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val items = BottomNavItem.entries
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                NavigationBar {
                    items.forEach { item ->
                        BuildBottomNavItem(currentRoute, item, navController)
                    }
                }
            }
        ) { padding ->

            BackHandler(enabled = currentRoute != BottomNavItem.Home.route) {
                navController.popBackStack()
            }

            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(padding),
                startDestination = BottomNavItem.Home.route
            )
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
                    }
                }
            }
        },
        icon = { Icon(item.icon, contentDescription = item.label) },
        label = { Text(item.label) }
    )
}
