package com.example.exchanges_presentation.list.view.state

import com.example.exchanges_domain.model.Exchange

sealed class ExchangeEvent {
    data class OnClickDetails(val exchange: com.example.exchanges_domain.model.Exchange) : ExchangeEvent()
    object OnLoad : ExchangeEvent()
}