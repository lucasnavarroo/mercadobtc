package com.example.mercadobitcoin.presentation.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mercadobitcoin.R
import com.example.mercadobitcoin.core.LocalSpacing
import com.example.mercadobitcoin.core.UiEvent
import com.example.mercadobitcoin.presentation.components.ExchangeCardHeader
import com.example.mercadobitcoin.presentation.components.ExchangeTextInfo
import com.example.mercadobitcoin.presentation.list.view.state.ExchangeEvent
import com.example.mercadobitcoin.presentation.list.viewmodel.ExchangeViewModel
import com.google.gson.Gson

@Composable
fun ExchangeScreen(
    scaffoldState: ScaffoldState,
    onDetailsClick: (item: String) -> Unit,
    viewModel: ExchangeViewModel,
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(ExchangeEvent.OnLoad)
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.toString()
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = spacing.spaceLarge,
                horizontal = spacing.spaceMedium
            ),
            text = stringResource(R.string.exchanges_title),
            style = MaterialTheme.typography.h3
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(state.exchanges) {
                Column(
                    modifier = Modifier
                        .clickable {
                            onDetailsClick(
                                Gson().toJson(it)
                            )
                        }
                        .padding(horizontal = spacing.spaceMedium)
                ) {
                    ExchangeCardHeader(
                        exchangeItem = it,
                        iconSize = 80.dp,
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceLarge))
                    ExchangeTextInfo(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(R.string.exchange_id),
                        value = it.exchangeId
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    ExchangeTextInfo(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(R.string.volume_one_hour_usd),
                        value = it.volumeOneHrsUsd
                    )
                }
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isSearching -> CircularProgressIndicator(color = Color.Black)
        }
    }
}