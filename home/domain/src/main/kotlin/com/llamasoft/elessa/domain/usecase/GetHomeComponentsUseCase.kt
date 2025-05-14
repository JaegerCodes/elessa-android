package com.llamasoft.elessa.domain.usecase

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeComponents
import com.llamasoft.elessa.domain.repository.ViewComponentsRepository

class GetHomeComponentsUseCase(
    private val repository: ViewComponentsRepository
) {
    suspend operator fun invoke(url: String): HomeComponents {
        return repository.getHomeComponents(url)
    }
}
