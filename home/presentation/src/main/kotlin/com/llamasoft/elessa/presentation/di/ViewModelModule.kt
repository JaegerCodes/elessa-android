package com.llamasoft.elessa.presentation.di

import com.llamasoft.elessa.presentation.components.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
}
