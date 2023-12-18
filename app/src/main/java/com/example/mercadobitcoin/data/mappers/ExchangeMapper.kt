package com.example.mercadobitcoin.data.mappers

import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.data.remote.ExchangeDTO

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