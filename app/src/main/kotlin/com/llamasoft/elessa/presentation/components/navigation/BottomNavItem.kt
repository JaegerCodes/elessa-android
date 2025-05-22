package com.llamasoft.elessa.presentation.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.llamasoft.elessa.presentation.components.screen.NAVIGATION_ROUTE_HOME

enum class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    Home(NAVIGATION_ROUTE_HOME, "Inicio", Icons.Default.Home),
    Checkout("checkout", "Compras", Icons.Default.ShoppingCart),
    Notifications("notifications", "Más", Icons.Default.Notifications)
}
