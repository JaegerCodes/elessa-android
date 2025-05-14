package com.llamasoft.elessa.domain.repository

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent

interface ViewComponentsRepository {
    suspend fun getViewComponents(): HomeContainerComponent
}
