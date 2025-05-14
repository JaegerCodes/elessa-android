package com.llamasoft.elessa.presentation.di

import org.koin.dsl.module

val homePresentationModule = module {
    includes(viewModelModule, homeFactoryModule)
}