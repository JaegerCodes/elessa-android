package com.llamasoft.elessa.presentation.components.section

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent

data class SectionTitleViewComponent(
    override val component: SectionTitleComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        SectionTitleView(component = component)
    }
}