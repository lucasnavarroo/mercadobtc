package com.example.mercadobitcoin.presentation.list.view.mappers

import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.presentation.list.model.ExchangeUI

fun Exchange.toPresentation() = ExchangeUI(
    exchangeId = exchangeId,
    webSite = webSite,
    name = name,
    volumeOneDayUsd = volumeOneDayUsd.toString(),
    volumeOneHrsUsd = volumeOneHrsUsd.toString(),
    volumeOneMthUsd = volumeOneMthUsd.toString(),
)