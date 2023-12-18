package com.example.mercadobitcoin.di.modules

import com.example.mercadobitcoin.presentation.list.viewmodel.ExchangeViewModel
import com.example.mercadobitcoin.domain.usecase.ExchangesUseCase
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

