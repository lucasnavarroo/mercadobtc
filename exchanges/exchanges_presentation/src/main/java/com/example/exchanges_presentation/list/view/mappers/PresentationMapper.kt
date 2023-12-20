package com.example.exchanges_presentation.list.view.mappers

import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_presentation.list.model.ExchangeUI

fun com.example.exchanges_domain.model.Exchange.toPresentation() = ExchangeUI(
    exchangeId = exchangeId,
    webSite = webSite,
    name = name,
    volumeOneDayUsd = volumeOneDayUsd.toString(),
    volumeOneHrsUsd = volumeOneHrsUsd.toString(),
    volumeOneMthUsd = volumeOneMthUsd.toString(),
)