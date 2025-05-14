package com.llamasoft.elessa.domain.model.action.base

import androidx.annotation.Keep
import androidx.annotation.StringDef

@Keep
@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ActionType.TRACK,
    ActionType.SHOW_SNACKBAR_ACTION,
    ActionType.NAVIGATE_DEEP_LINK,
)
annotation class ActionType {
    companion object {
        const val TRACK = "Track"
        const val SHOW_SNACKBAR_ACTION = "ShowSnackbarAction"
        const val NAVIGATE_DEEP_LINK = "NavigateToDeepLink"
    }
}
