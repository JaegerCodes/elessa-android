package com.llamasoft.elessa.presentation.components.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.presentation.components.shimmer.ShimmerUtils
import com.llamasoft.elessa.presentation.components.shimmer.ViewOrShimmer
import com.llamasoft.elessa.presentation.factory.ViewComponent
import com.llamasoft.elessa.ui.theme.ElessaTheme

data class TopBarShimmerViewComponent(
    val component: TopBarShimmerComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        ViewOrShimmer(shimmerId = component.shimmerId) {
            TopBarShimmerView()
        }
    }
}

@Composable
private fun TopBarShimmerView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp, top = 8.dp)
    ) {
        ShimmerUtils.GetShimmerBlockTitle(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        ShimmerUtils.GetShimmerBlockTitle(
            modifier = Modifier
                .width(48.dp)
                .height(48.dp),
            roundedSize = 16.dp
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun TopBarShimmerViewPreview() {
    ElessaTheme {
        TopBarShimmerView()
    }
}
