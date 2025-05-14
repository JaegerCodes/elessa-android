package com.llamasoft.elessa.domain.di

import org.koin.dsl.module

val homeDomainModule = module {
    includes(useCaseModule)
}