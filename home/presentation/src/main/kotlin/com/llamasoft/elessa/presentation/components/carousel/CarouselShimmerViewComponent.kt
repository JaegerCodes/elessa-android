package com.llamasoft.elessa.presentation.components.carousel

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.shimmer.CarouselShimmerComponent
import com.llamasoft.elessa.presentation.components.shimmer.ShimmerUtils
import com.llamasoft.elessa.presentation.components.shimmer.ViewOrShimmer
import com.llamasoft.elessa.presentation.factory.ViewComponent
import com.llamasoft.elessa.ui.theme.ElessaTheme

data class CarouselShimmerViewComponent(
    override val component: CarouselShimmerComponent
) : ViewComponent {
    @Composable
    override fun Render() {
        ViewOrShimmer(shimmerId = component.shimmerId) {
            CarouselShimmerView()
        }
    }
}

@Composable
private fun CarouselShimmerView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp)
    ) {
        ShimmerUtils.GetShimmerBlockTitle(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(150.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        ShimmerUtils.GetShimmerBlockTitle(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .height(150.dp)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CarouselShimmerViewPreview() {
    ElessaTheme {
        CarouselShimmerView()
    }
}
