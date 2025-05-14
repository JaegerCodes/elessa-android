package com.llamasoft.elessa.app

import android.app.Application
import com.llamasoft.elessa.data.di.homeDataModule
import com.llamasoft.elessa.domain.di.homeDomainModule
import com.llamasoft.elessa.network.provider.networkModule
import com.llamasoft.elessa.presentation.di.homePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ElessaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ElessaApp)
            modules(
                networkModule,
                homeDataModule,
                homeDomainModule,
                homePresentationModule
            )
        }
    }
}
