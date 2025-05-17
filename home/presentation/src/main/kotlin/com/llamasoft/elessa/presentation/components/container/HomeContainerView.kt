package com.llamasoft.elessa.presentation.components.container

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.presentation.factory.UiViewComponent

@Composable
fun HomeContainerView(component: HomeContainerComponent) {
    LazyColumn(
        modifier = Modifier
            .testTag("HomeContainerTestTag")
    ) {
        component.children?.forEach { child ->
            item {
                UiViewComponent(
                    component = child
                )
            }
        }
    }
}
