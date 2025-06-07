package com.llamasoft.elessa.notifications.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.llamasoft.elessa.ui.theme.ElessaTheme

@Composable
fun NotificationsScreen() {
    ElessaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                "Notifications",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
