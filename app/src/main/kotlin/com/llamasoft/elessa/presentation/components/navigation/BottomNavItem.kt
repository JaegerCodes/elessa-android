package com.llamasoft.elessa.presentation.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.llamasoft.elessa.presentation.components.home.NAVIGATION_ROUTE_HOME
import com.llamasoft.elessa.presentation.components.home.NAVIGATION_ROUTE_PROFILE
import com.llamasoft.elessa.presentation.components.home.NAVIGATION_ROUTE_SEARCH

enum class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    Home(NAVIGATION_ROUTE_HOME, "Inicio", Icons.Default.Home),
    Search(NAVIGATION_ROUTE_SEARCH, "Buscar", Icons.Default.Search),
    Profile(NAVIGATION_ROUTE_PROFILE, "Perfil", Icons.Default.Person)
}
