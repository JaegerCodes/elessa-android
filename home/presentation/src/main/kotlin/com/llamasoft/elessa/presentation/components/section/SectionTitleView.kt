package com.llamasoft.elessa.presentation.components.section

import androidx.compose.runtime.Composable
import com.llamasoft.elessa.accessibility.getSemanticsProperties
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponent
import com.llamasoft.elessa.ui.text.ElSectionTitle

@Composable
fun SectionTitleView(
    component: SectionTitleComponent
) {
    ElSectionTitle(
        title = component.data?.text.orEmpty(),
        accessibility = getSemanticsProperties(component.data?.accessibility)
    )
}
