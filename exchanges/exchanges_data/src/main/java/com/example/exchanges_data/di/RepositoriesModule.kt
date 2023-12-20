package com.example.exchanges_data.di

import com.example.exchanges_data.remote.ExchangeAPI
import com.example.exchanges_data.repository.ExchangeRepositoryImpl
import com.example.exchanges_domain.repository.ExchangeRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<ExchangeRepository> { provideExchangeRepository(get()) }
}

fun provideExchangeRepository(exchangeApi: ExchangeAPI): ExchangeRepositoryImpl {
    return ExchangeRepositoryImpl(
        api = exchangeApi
    )
}
