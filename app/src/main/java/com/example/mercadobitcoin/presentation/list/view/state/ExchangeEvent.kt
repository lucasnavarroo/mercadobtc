package com.example.mercadobitcoin.presentation.list.view.state

import com.example.mercadobitcoin.domain.model.Exchange

sealed class ExchangeEvent {
    data class OnClickDetails(val exchange: Exchange) : ExchangeEvent()
    object OnLoad : ExchangeEvent()
}