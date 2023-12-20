package com.example.mercadobitcoin.di.modules

import com.example.exchanges_domain.usecase.ExchangesUseCase
import com.example.exchanges_presentation.list.viewmodel.ExchangeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { provideExchangeViewModel(get()) }
}

fun provideExchangeViewModel(exchangesUseCase: ExchangesUseCase): ExchangeViewModel {
    return ExchangeViewModel(
        exchangesUseCase = exchangesUseCase
    )
}

