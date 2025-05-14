package com.llamasoft.elessa.presentation.components.container

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.presentation.factory.UiViewComponent

@Composable
fun HomeContainerView(component: HomeContainerComponent) {
    Column(
        modifier = Modifier
            .testTag("HomeContainerTestTag")
    ) {
        component.children?.forEach { child ->
            UiViewComponent(
                component = child
            )
        }
    }
}
