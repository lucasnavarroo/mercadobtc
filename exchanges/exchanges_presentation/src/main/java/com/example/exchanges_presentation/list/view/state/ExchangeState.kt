package com.example.exchanges_presentation.list.view.state

import com.example.exchanges_presentation.list.model.ExchangeUI

data class ExchangeState(
    val isSearching: Boolean = false,
    val exchanges: List<ExchangeUI> = emptyList()
)