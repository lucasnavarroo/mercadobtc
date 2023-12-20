package com.example.exchanges_domain.di

import com.example.exchanges_domain.repository.ExchangeRepository
import com.example.exchanges_domain.usecase.ExchangesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single<ExchangesUseCase> { provideExchangesUseCase(get()) }
}

fun provideExchangesUseCase(exchangeRepository: ExchangeRepository): ExchangesUseCase {
    return ExchangesUseCase(
        repository = exchangeRepository
    )
}