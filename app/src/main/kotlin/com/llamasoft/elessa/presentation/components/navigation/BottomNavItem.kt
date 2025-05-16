package com.llamasoft.elessa.presentation.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.llamasoft.elessa.presentation.components.screen.NAVIGATION_ROUTE_HOME

enum class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    Home(NAVIGATION_ROUTE_HOME, "Inicio", Icons.Default.Home),
    Search("search", "Buscar", Icons.Default.Search),
    Profile("profile", "Perfil", Icons.Default.Person)
}
