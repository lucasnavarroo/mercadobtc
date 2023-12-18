package com.example.mercadobitcoin.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mercadobitcoin.R
import com.example.mercadobitcoin.core.LocalSpacing
import com.example.mercadobitcoin.presentation.components.ExchangeCardHeader
import com.example.mercadobitcoin.presentation.components.ExchangeTextInfo
import com.example.mercadobitcoin.presentation.list.model.ExchangeUI

@Composable
fun ExchangeDetailsScreen(
    exchangeItem: ExchangeUI,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val spacing = LocalSpacing.current

        Column(
            modifier = Modifier.padding(horizontal = spacing.spaceMedium)
        ) {
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Image(
                modifier = Modifier.clickable { onBackClick() },
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = stringResource(R.string.back),
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            ExchangeCardHeader(
                exchangeItem = exchangeItem,
                iconSize = 90.dp,
                isIconVisible = false,
                titleStyle = MaterialTheme.typography.h6,
                subTitleStyle = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            ExchangeTextInfo(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(R.string.exchange_id),
                value = exchangeItem.exchangeId
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            ExchangeTextInfo(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(R.string.volume_one_hour_usd),
                value = exchangeItem.volumeOneHrsUsd
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            ExchangeTextInfo(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(R.string.volume_one_day),
                value = exchangeItem.volumeOneDayUsd
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            ExchangeTextInfo(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(R.string.volume_one_month),
                value = exchangeItem.volumeOneMthUsd
            )
        }
    }
}