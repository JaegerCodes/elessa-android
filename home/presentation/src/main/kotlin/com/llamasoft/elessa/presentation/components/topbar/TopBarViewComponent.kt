package com.llamasoft.elessa.presentation.components.topbar

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent

data class TopBarViewComponent(
    val component: TopBarComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        TopBarView(component = component)
    }
}
