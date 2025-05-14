package com.llamasoft.elessa.data.di

import com.llamasoft.elessa.data.repository.RemoteViewComponents
import com.llamasoft.elessa.domain.repository.ViewComponentsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ViewComponentsRepository> {
        RemoteViewComponents(
            service = get(),
            moshi = get()
        )
    }
}
