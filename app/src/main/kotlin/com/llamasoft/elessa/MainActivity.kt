package com.llamasoft.elessa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.llamasoft.elessa.presentation.components.home.MainScreen
import com.llamasoft.elessa.ui.theme.ElessaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElessaTheme {
                MainScreen()
            }
        }
    }
}
