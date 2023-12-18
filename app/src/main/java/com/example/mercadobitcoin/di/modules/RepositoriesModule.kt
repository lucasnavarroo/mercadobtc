package com.example.mercadobitcoin.di.modules

import com.example.mercadobitcoin.data.remote.ExchangeAPI
import com.example.mercadobitcoin.domain.repository.ExchangeRepository
import com.example.mercadobitcoin.data.repository.ExchangeRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<ExchangeRepository> { provideExchangeRepository(get()) }
}

fun provideExchangeRepository(exchangeApi: ExchangeAPI): ExchangeRepositoryImpl {
    return ExchangeRepositoryImpl(
        api = exchangeApi
    )
}
