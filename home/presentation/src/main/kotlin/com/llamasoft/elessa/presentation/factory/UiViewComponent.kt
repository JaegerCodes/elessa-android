package com.llamasoft.elessa.presentation.factory

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.model.sdui.ElViewComponent
import org.koin.compose.koinInject

@Composable
fun UiViewComponent(component: ElViewComponent?) {
    val factory: ViewComponentsFactory = koinInject()

    component?.let {
        factory.create(component)?.Render()
    }
}
