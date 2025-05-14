package com.llamasoft.elessa.presentation.components.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.presentation.components.notification.NotificationButton
import com.llamasoft.elessa.ui.theme.LocalElTypography

@Composable
fun TopBarView(
    component: TopBarComponent
) {
    val typography = LocalElTypography.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp, top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = component.data?.userTitle.orEmpty(),
            style = typography.userID,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        HeaderButtons(component)
    }
}

@Composable
fun HeaderButtons(
    component: TopBarComponent
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.End
    ) {
        NotificationButton(
            data = component.data?.notificationButton
        )
    }
}
