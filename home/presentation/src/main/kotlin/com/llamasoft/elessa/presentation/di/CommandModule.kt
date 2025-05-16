package com.llamasoft.elessa.presentation.di

import com.llamasoft.elessa.presentation.command.ActionCommandViewModel
import com.llamasoft.elessa.presentation.factory.CommandActionFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commandModule = module {
    single { CommandActionFactory() }
    viewModel { ActionCommandViewModel(get()) }
}
