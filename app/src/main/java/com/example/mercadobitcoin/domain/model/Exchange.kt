package com.example.mercadobitcoin.domain.model

data class Exchange(
    val exchangeId: String,
    val webSite: String,
    val name: String,
    val volumeOneDayUsd: Double,
    val volumeOneHrsUsd: Double,
    val volumeOneMthUsd: Double,
)