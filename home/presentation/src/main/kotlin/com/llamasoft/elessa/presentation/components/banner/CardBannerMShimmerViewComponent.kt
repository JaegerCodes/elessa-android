package com.llamasoft.elessa.presentation.components.banner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.shimmer.CardBannerMShimmerComponent
import com.llamasoft.elessa.presentation.components.shimmer.ShimmerUtils
import com.llamasoft.elessa.presentation.components.shimmer.ViewOrShimmer
import com.llamasoft.elessa.presentation.factory.ViewComponent
import com.llamasoft.elessa.ui.theme.ElessaTheme

data class CardBannerMShimmerViewComponent(
    override val component: CardBannerMShimmerComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        ViewOrShimmer(shimmerId = component.shimmerId) {
            CardBannerXLShimmerView()
        }
    }
}

@Composable
private fun CardBannerXLShimmerView() {
    ShimmerUtils.GetShimmerBlockTitle(
        modifier = Modifier
            .padding(bottom = 2.dp)
            .fillMaxWidth()
            .height(90.dp),
        roundedSize = 16.dp
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun CardBannerMShimmerViewPreview() {
    ElessaTheme {
        CardBannerXLShimmerView()
    }
}
