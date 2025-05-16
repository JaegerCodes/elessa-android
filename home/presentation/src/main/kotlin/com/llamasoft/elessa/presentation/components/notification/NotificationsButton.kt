package com.llamasoft.elessa.presentation.components.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.llamasoft.elessa.domain.model.component.buttons.SquaredButtonData
import com.llamasoft.elessa.home.presentation.R
import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.components.button.SquaredButtonContainer
import com.llamasoft.elessa.ui.status.badge.ElBadgeHighlight
import com.llamasoft.elessa.ui.status.badge.ElBadgeHighlightStyle
import org.koin.androidx.compose.koinViewModel

@Composable
fun NotificationButton(
    modifier: Modifier = Modifier,
    data: SquaredButtonData?
) {
    val commandViewModel: ActionCommandViewModel = koinViewModel()
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopEnd
    ) {
        SquaredButtonContainer(
            accessibility = data?.accessibility,
            buttonTag = "NotificationButtonTagTest",
            onClick = {
                commandViewModel.dispatchAll(data?.actions)
            }
        ) {
            NotificationsAnimationWidget(
                shouldAnimate = true
            )
        }
        BadgeWidget(data?.unreadNotifications ?: 0)
    }
}

@Composable
fun BadgeWidget(
    unreadNotifications: Int
) {
    if (unreadNotifications <= 0) return
    val notificationText = if (unreadNotifications > 9) {
        stringResource(R.string.notifications_max_count)
    } else {
        unreadNotifications.toString()
    }
    ElBadgeHighlight(
        modifier = Modifier
            .testTag("NotificationsBadgeTagTest"),
        text = notificationText,
        style = ElBadgeHighlightStyle.SECONDARY
    )
}
