package com.llamasoft.elessa.presentation.components.section

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.shimmer.SectionTitleShimmerComponent
import com.llamasoft.elessa.presentation.components.shimmer.ShimmerUtils
import com.llamasoft.elessa.presentation.components.shimmer.ViewOrShimmer
import com.llamasoft.elessa.presentation.factory.ViewComponent
import com.llamasoft.elessa.ui.theme.ElessaTheme

data class SectionTitleShimmerViewComponent(
    val component: SectionTitleShimmerComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        ViewOrShimmer(shimmerId = component.shimmerId) {
            SectionTitleShimmerView()
        }
    }
}

@Composable
private fun SectionTitleShimmerView() {
    ShimmerUtils.GetShimmerBlockTitle(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(48.dp),
        roundedSize = 16.dp
    )
}

@Preview(
    showBackground = true
)
@Composable
fun SectionTitleShimmerViewPreview() {
    ElessaTheme {
        SectionTitleShimmerView()
    }
}
