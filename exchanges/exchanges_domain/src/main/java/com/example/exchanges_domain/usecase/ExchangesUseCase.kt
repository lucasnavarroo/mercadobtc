package com.example.exchanges_domain.usecase

import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_domain.repository.ExchangeRepository

class ExchangesUseCase(
    private val repository: ExchangeRepository
) {
    suspend operator fun invoke(): Result<List<Exchange>> = repository.getExchanges()
}