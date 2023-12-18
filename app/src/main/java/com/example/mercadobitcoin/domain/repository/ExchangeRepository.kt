package com.example.mercadobitcoin.domain.repository

import com.example.mercadobitcoin.domain.model.Exchange

interface ExchangeRepository {
    suspend fun getExchanges(): Result<List<Exchange>>
}