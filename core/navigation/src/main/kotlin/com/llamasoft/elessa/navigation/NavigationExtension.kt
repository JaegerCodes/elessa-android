package com.llamasoft.elessa.navigation

import android.net.Uri
import androidx.navigation.NavController

fun NavController.safeNavigate(route: String) {
    try {
        val uri = Uri.parse(route)
        navigate(uri)
    } catch (_: IllegalArgumentException) {
        return
    }
}
