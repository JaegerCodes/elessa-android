package com.llamasoft.elessa.domain.usecase

import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.repository.ViewComponentsRepository

class GetHomeComponentsUseCase(
    private val repository: ViewComponentsRepository
) {
    suspend operator fun invoke(): HomeContainerComponent {
        return repository.getViewComponents()
    }
}
