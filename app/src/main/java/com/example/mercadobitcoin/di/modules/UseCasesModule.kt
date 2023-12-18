package com.example.mercadobitcoin.di.modules

import com.example.mercadobitcoin.domain.repository.ExchangeRepository
import com.example.mercadobitcoin.domain.usecase.ExchangesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single<ExchangesUseCase> { provideExchangesUseCase(get()) }
}

fun provideExchangesUseCase(exchangeRepository: ExchangeRepository): ExchangesUseCase {
    return ExchangesUseCase(
        repository = exchangeRepository
    )
}