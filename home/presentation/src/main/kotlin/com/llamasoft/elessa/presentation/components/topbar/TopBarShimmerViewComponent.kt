package com.llamasoft.elessa.presentation.components.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.presentation.components.home.HomeViewModel
import com.llamasoft.elessa.presentation.components.shimmer.ShimmerUtils
import com.llamasoft.elessa.presentation.components.shimmer.ViewOrShimmer
import com.llamasoft.elessa.presentation.factory.UiViewComponent
import com.llamasoft.elessa.presentation.factory.ViewComponent
import org.koin.androidx.compose.koinViewModel

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
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            ShimmerUtils.GetShimmerBlockTitle(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(190.dp)
                    .height(48.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            ShimmerUtils.GetShimmerBlockTitle(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .width(48.dp)
                    .height(48.dp),
                roundedSize = 16.dp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
