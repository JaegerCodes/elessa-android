package com.llamasoft.elessa.ui.status

import androidx.compose.ui.graphics.Color
import com.llamasoft.elessa.ui.R
import com.llamasoft.elessa.ui.theme.ElColorPalette

enum class State(
    val state: String,
    val backgroundColor: Color,
    val textColor: Color,
    val icon: Int?,
    val iconColor: Color
) {
    INFO(
        "info",
        ElColorPalette.UI_LS_INFO_200,
        ElColorPalette.UI_LS_INFO_600,
        R.drawable.icon_alert_circle_fill,
        ElColorPalette.UI_LS_INFO_600
    ),
    SUCCESS(
        "success",
        ElColorPalette.UI_LS_SUCCESS_200,
        ElColorPalette.UI_LS_SUCCESS_600,
        R.drawable.icon_check_circle_fill,
        ElColorPalette.UI_LS_SUCCESS_600
    ),
    WARNING(
        "warning",
        ElColorPalette.UI_LS_WARNING_200,
        ElColorPalette.UI_LS_WARNING_700,
        R.drawable.icon_alert_triangle_fill,
        ElColorPalette.UI_LS_WARNING_600
    ),
    ERROR(
        "error",
        ElColorPalette.UI_LS_ERROR_200,
        ElColorPalette.UI_LS_ERROR_700,
        R.drawable.icon_alert_circle_fill,
        ElColorPalette.UI_LS_ERROR_600
    ),
    PROCESS(
        "process",
        ElColorPalette.UI_LS_INFO_200,
        ElColorPalette.UI_LS_INFO_600,
        R.drawable.icon_clock_fill,
        ElColorPalette.UI_LS_INFO_600
    ),
    GREEN(
        "green_style",
        ElColorPalette.UI_LS_SUCCESS_600,
        ElColorPalette.UI_LS_NEUTRAL_100,
        null,
        ElColorPalette.UI_LS_NEUTRAL_600
    ),
    ORANGE(
        "orange_style",
        ElColorPalette.UI_LS_SECONDARY_500,
        ElColorPalette.UI_LS_NEUTRAL_100,
        null,
        ElColorPalette.UI_LS_NEUTRAL_600
    ),
    LIGHT_ORANGE(
        "light_orange_style",
        ElColorPalette.UI_LS_SECONDARY_200,
        ElColorPalette.UI_LS_SECONDARY_600,
        null,
        ElColorPalette.UI_LS_NEUTRAL_600
    ),
    VIOLET(
        "violet_style",
        ElColorPalette.UI_LS_PRIMARY_200,
        ElColorPalette.UI_LS_PRIMARY_500,
        null,
        ElColorPalette.UI_LS_NEUTRAL_600
    )
}
