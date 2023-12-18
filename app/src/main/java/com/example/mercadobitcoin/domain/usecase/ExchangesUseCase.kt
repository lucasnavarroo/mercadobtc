package com.example.mercadobitcoin.domain.usecase

import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.domain.repository.ExchangeRepository

class ExchangesUseCase(
    private val repository: ExchangeRepository
) {
    suspend operator fun invoke(): Result<List<Exchange>> = repository.getExchanges()
}