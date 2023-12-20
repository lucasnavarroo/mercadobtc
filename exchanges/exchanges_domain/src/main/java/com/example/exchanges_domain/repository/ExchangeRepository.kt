package com.example.exchanges_domain.repository

import com.example.exchanges_domain.model.Exchange

interface ExchangeRepository {
    suspend fun getExchanges(): Result<List<Exchange>>
}