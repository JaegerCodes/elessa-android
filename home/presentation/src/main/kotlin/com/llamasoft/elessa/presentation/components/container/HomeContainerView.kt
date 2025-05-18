package com.llamasoft.elessa.presentation.components.container

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.presentation.factory.UiViewComponent

@Composable
fun HomeContainerView(component: HomeContainerComponent) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp),
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .testTag("HomeContainerTestTag")
    ) {
        component.children?.forEach { child ->
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                UiViewComponent(
                    component = child
                )
            }
        }
    }
}
