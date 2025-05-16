package com.llamasoft.elessa.presentation.command

import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkAction
import com.llamasoft.elessa.domain.model.action.navigate.NavigateDeeplinkData

class NavigateCommand : FlowCommand<NavigateDeeplinkAction, NavigateDeeplinkData>() {
    override fun extractData(action: NavigateDeeplinkAction): NavigateDeeplinkData {
        return action.data
    }
}
