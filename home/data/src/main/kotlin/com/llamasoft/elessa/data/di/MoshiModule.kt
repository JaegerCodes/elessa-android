package com.llamasoft.elessa.data.di

import com.llamasoft.elessa.data.network.ViewComponentsService
import com.llamasoft.elessa.data.sdui.provider.ActionAdapterProviderImpl
import com.llamasoft.elessa.data.sdui.provider.ComponentAdapterProviderImpl
import com.llamasoft.elessa.model.sdui.ActionAdapterProvider
import com.llamasoft.elessa.model.sdui.ComponentAdapterProvider
import com.llamasoft.elessa.model.sdui.ElAction
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.network.factory.MoshiFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_TYPE_FIELD = "type"
private const val BASE_URL = "https://jsonblob.com/api/"

val sduiModule = module {
    single<ComponentAdapterProvider> { ComponentAdapterProviderImpl() }
    single<ActionAdapterProvider> { ActionAdapterProviderImpl() }

    single {
        val componentFactory = get<ComponentAdapterProvider>()
            .provide(PolymorphicJsonAdapterFactory.of(ElViewComponent::class.java, BASE_TYPE_FIELD))

        val actionFactory = get<ActionAdapterProvider>()
            .provide(PolymorphicJsonAdapterFactory.of(ElAction::class.java, BASE_TYPE_FIELD))

        val moshiFactory = get<MoshiFactory>()
        moshiFactory.create(
            extraAdapters = listOf(componentFactory, actionFactory)
        )
    }

    single<ViewComponentsService> {
        val moshi = get<Moshi>()
        val retrofit = get<Retrofit> {
            parametersOf(moshi, BASE_URL)
        }
        retrofit.create(ViewComponentsService::class.java)
    }
}
