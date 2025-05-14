package com.llamasoft.elessa.network.provider

import com.llamasoft.elessa.network.factory.MoshiFactory
import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponseAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }

    single { MoshiFactory() }

    factory { (moshi: Moshi, baseUrl: String) ->
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ElInterceptedResponseAdapterFactory())
            .build()
    }
}
