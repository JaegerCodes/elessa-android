package com.llamasoft.elessa.data.repository

import com.llamasoft.elessa.data.network.ViewComponentsService
import com.llamasoft.elessa.data.util.fromJsonOrThrow
import com.llamasoft.elessa.data.util.mapSuccessOrError
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.repository.ViewComponentsRepository
import com.squareup.moshi.Moshi

class RemoteViewComponents(
    private val service: ViewComponentsService,
    private val moshi: Moshi
): ViewComponentsRepository {
    override suspend fun getViewComponents(): HomeContainerComponent {
        return service.getViewComponents().mapSuccessOrError { body ->
            val json = body.string()
            moshi.fromJsonOrThrow<HomeContainerComponent>(json)
        }
    }
}
