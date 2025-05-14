package com.llamasoft.elessa.data.di

import org.koin.dsl.module

val homeDataModule = module {
    includes(sduiModule, repositoryModule)
}
