package com.example.exchanges_presentation.list.model

import androidx.annotation.DrawableRes
import com.example.exchanges_domain.model.Exchange
import com.example.mercadobitcoin.R

data class ExchangeUI(
    val exchangeId: String,
    val webSite: String,
    val name: String,
    val volumeOneDayUsd: String,
    val volumeOneHrsUsd: String,
    val volumeOneMthUsd: String,
    @DrawableRes val icon: Int = R.drawable.bitcoin_logo_svgrepo_com,
)
