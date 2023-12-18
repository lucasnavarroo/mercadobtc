package com.example.mercadobitcoin.presentation.list.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadobitcoin.R
import com.example.mercadobitcoin.core.UiEvent
import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.domain.usecase.ExchangesUseCase
import com.example.mercadobitcoin.presentation.list.view.ExchangeEvent
import com.example.mercadobitcoin.presentation.list.view.ExchangeState
import com.example.mercadobitcoin.presentation.list.model.ExchangeUI
import com.example.mercadobitcoin.presentation.list.view.mappers.toPresentation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ExchangeViewModel(
    private val exchangesUseCase: ExchangesUseCase
): ViewModel() {

    var state by mutableStateOf(ExchangeState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ExchangeEvent) {
        when(event) {
            is ExchangeEvent.OnClickDetails -> {}
            ExchangeEvent.OnLoad -> {
                getExchanges()
            }
        }
    }

    private fun getExchanges() {
        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                exchanges = emptyList()
            )
            exchangesUseCase()
                .onSuccess { exchanges ->
                    state = state.copy(
                        exchanges = exchanges.map { it.toPresentation() },
                        isSearching = false,
                    )
                }
                .onFailure {
                    state = state.copy(isSearching = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            R.string.error_message
                        )
                    )
                }
        }
    }
}
