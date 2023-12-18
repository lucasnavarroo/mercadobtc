package com.example.mercadobitcoin.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeAPI {

    @GET("exchanges")
    suspend fun getAllExchanges(
        @Query("apiKey") query: String = "52C923E9-C284-4BB8-9386-8EBF465CCF7A",
    ): List<ExchangeDTO>

    companion object {
        const val BASE_URL = "https://rest.coinapi.io/v1/"
    }
}