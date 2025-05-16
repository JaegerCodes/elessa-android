package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkAction
import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class NavigateCommand : FlowCommand<NavigateDeeplinkAction, NavigateDeeplinkData>() {
    override fun extractData(action: NavigateDeeplinkAction) = action.data
}
