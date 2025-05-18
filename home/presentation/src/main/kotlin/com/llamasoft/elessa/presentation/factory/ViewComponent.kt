package com.llamasoft.elessa.presentation.factory

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.model.sdui.ElViewComponent

interface ViewComponent {
    val component: ElViewComponent
    @Composable
    fun Render()
}
