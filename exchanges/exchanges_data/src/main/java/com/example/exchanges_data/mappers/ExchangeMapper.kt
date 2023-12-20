package com.example.exchanges_data.mappers

import com.example.exchanges_data.remote.ExchangeDTO
import com.example.exchanges_domain.model.Exchange

fun ExchangeDTO.toData(): Exchange {
    return Exchange(
        exchangeId = exchangeId ?: "",
        webSite = webSite ?: "",
        name = name ?: "",
        volumeOneDayUsd = volumeOneDayUsd ?: 0.0,
        volumeOneMthUsd = volumeOneMthUsd ?: 0.0,
        volumeOneHrsUsd = volumeOneHrsUsd ?: 0.0,
    )
}