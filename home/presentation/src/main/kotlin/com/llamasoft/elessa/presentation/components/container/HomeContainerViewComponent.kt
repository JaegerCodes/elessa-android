package com.llamasoft.elessa.presentation.components.container

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent

data class HomeContainerViewComponent(
    override val component: HomeContainerComponent
): ViewComponent {
    @Composable
    override fun Render() {
        HomeContainerView(component = component)
    }
}
