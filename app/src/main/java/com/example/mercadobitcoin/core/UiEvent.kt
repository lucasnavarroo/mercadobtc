package com.example.mercadobitcoin.core

sealed class UiEvent {
    data class ShowSnackbar(val message: Int): UiEvent()
}
