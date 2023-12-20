package com.example.mercadobitcoin

import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_domain.repository.ExchangeRepository

class ExchangeRepositoryFake: ExchangeRepository {

    var shouldReturnError = false

    var exchangesResult = listOf<Exchange>()

    override suspend fun getExchanges(): Result<List<Exchange>> {
        return if(shouldReturnError) {
            Result.failure(Throwable())
        } else {
            Result.success(exchangesResult)
        }
    }
}
