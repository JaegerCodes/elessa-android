package com.llamasoft.elessa.ui.theme

import androidx.compose.runtime.Immutable
import com.llamasoft.elessa.ui.theme.dimens.ElElevationTokens
import com.llamasoft.elessa.ui.theme.dimens.ElSizeTokens
import com.llamasoft.elessa.ui.theme.dimens.ElSpacingTokens
import com.llamasoft.elessa.ui.theme.dimens.defaultElElevationTokens
import com.llamasoft.elessa.ui.theme.dimens.defaultElSizeTokens
import com.llamasoft.elessa.ui.theme.dimens.defaultElSpacingTokens

@Suppress("LongParameterList")
@Immutable
class ElDimenTokens(
    val elevation: ElElevationTokens,
    val size: ElSizeTokens,
    val spacing: ElSpacingTokens,
)

internal val defaultDimenTokens: ElDimenTokens = ElDimenTokens(
    elevation = defaultElElevationTokens,
    size = defaultElSizeTokens,
    spacing = defaultElSpacingTokens,
)
