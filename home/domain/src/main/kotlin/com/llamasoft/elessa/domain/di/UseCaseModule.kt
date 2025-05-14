package com.llamasoft.elessa.domain.di

import com.llamasoft.elessa.domain.usecase.GetHomeComponentsUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { GetHomeComponentsUseCase(get()) }
}