package com.llamasoft.elessa.presentation.di

import com.llamasoft.elessa.presentation.factory.ViewComponentsFactory
import org.koin.dsl.module

val homeFactoryModule = module {
    single { ViewComponentsFactory() }
}
