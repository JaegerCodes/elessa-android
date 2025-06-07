package com.llamasoft.elessa.domain.di

import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import com.llamasoft.elessa.domain.usecase.GetHomeContainerUseCase
import org.koin.dsl.module


internal val useCaseModule = module {
    single { GetHomeContainerUseCase(get()) }
    single { GetHomeComponentsUseCase(get()) }
}
