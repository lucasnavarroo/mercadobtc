package com.example.mercadobitcoin.data.repository

import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.data.remote.ExchangeAPI
import com.example.mercadobitcoin.data.mappers.toData
import com.example.mercadobitcoin.domain.repository.ExchangeRepository

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