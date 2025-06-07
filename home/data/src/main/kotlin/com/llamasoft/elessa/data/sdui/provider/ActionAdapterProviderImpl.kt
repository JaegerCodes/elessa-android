package com.llamasoft.elessa.data.sdui.provider

import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.NAVIGATE_DEEP_LINK
import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.SHOW_SNACKBAR_ACTION
import com.llamasoft.elessa.domain.model.action.base.ActionType.Companion.TRACK
import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkAction
import com.llamasoft.elessa.domain.model.action.snackbar.ShowSnackbarAction
import com.llamasoft.elessa.domain.model.action.track.TrackAction
import com.llamasoft.elessa.model.sdui.ActionAdapterProvider
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.model.sdui.UnknownAction
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

internal class ActionAdapterProviderImpl : ActionAdapterProvider {
    override fun provide(
        factory: PolymorphicJsonAdapterFactory<ElAction>
    ): PolymorphicJsonAdapterFactory<ElAction> {
        return factory
            .withDefaultValue(UnknownAction)
            .withSubtype(TrackAction::class.java, TRACK)
            .withSubtype(NavigateDeeplinkAction::class.java, NAVIGATE_DEEP_LINK)
            .withSubtype(ShowSnackbarAction::class.java, SHOW_SNACKBAR_ACTION)
    }
}
