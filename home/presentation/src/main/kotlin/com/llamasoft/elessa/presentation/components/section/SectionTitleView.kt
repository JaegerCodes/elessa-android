package com.llamasoft.elessa.presentation.components.section

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.llamasoft.elessa.accessibility.getSemanticsProperties
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponent
import com.llamasoft.elessa.domain.model.component.section.SectionTitleComponentData
import com.llamasoft.elessa.ui.text.ElSectionTitle
import com.llamasoft.elessa.ui.theme.ElessaTheme

@Composable
fun SectionTitleView(
    component: SectionTitleComponent
) {
    ElSectionTitle(
        title = component.data?.text.orEmpty(),
        accessibility = getSemanticsProperties(component.data?.accessibility)
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun SectionTitlePreview() {
    ElessaTheme {
        SectionTitleView(
            component = SectionTitleComponent(
                data = SectionTitleComponentData(
                    text = "Section Title",
                    accessibility = null
                )
            )
        )
    }
}
