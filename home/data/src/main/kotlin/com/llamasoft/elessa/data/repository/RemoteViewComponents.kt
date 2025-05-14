package com.llamasoft.elessa.data.repository

import com.llamasoft.elessa.data.network.ViewComponentsService
import com.llamasoft.elessa.data.util.fromJsonOrError
import com.llamasoft.elessa.data.util.mapSuccessOrError
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeComponents
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.repository.ViewComponentsRepository
import com.squareup.moshi.Moshi

class RemoteViewComponents(
    private val service: ViewComponentsService,
    private val moshi: Moshi
): ViewComponentsRepository {
    override suspend fun getHomeContainer() = service.getHomeContainer()
        .mapSuccessOrError {
            body -> moshi.fromJsonOrError<HomeContainerComponent>(body.string())
        }

    override suspend fun getHomeComponents(url: String) = service.getHomeComponents()
        .mapSuccessOrError {
            body -> moshi.fromJsonOrError<HomeComponents>(body.string())
        }
}
