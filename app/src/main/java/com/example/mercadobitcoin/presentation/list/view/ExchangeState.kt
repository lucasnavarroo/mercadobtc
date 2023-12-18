package com.example.mercadobitcoin.presentation.list.view

import com.example.mercadobitcoin.presentation.list.model.ExchangeUI

data class ExchangeState(
    val isSearching: Boolean = false,
    val exchanges: List<ExchangeUI> = emptyList()
)