package com.llamasoft.elessa.domain.repository

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeComponents
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent

interface ViewComponentsRepository {
    suspend fun getHomeContainer(): Result<HomeContainerComponent>
    suspend fun getHomeComponents(url: String): Result<HomeComponents>
}
