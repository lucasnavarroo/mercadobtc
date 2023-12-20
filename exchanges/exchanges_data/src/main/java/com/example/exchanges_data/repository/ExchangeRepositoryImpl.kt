package com.example.exchanges_data.repository

import com.example.exchanges_data.remote.ExchangeAPI
import com.example.exchanges_data.mappers.toData
import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_domain.repository.ExchangeRepository

class ExchangeRepositoryImpl(
    private val api: ExchangeAPI
) : ExchangeRepository {

    override suspend fun getExchanges(): Result<List<Exchange>> {
        return try {
            val exchangesDTO = api.getAllExchanges()
            Result.success(exchangesDTO.map { it.toData() })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}