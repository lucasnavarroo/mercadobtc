package com.example.mercadobitcoin.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mercadobitcoin.R
import com.example.mercadobitcoin.core.LocalSpacing
import com.example.mercadobitcoin.presentation.list.model.ExchangeUI

@Composable
fun ExchangeCardHeader(
    exchangeItem: ExchangeUI,
    iconSize: Dp = 80.dp,
    titleStyle: TextStyle = MaterialTheme.typography.body1,
    subTitleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    isIconVisible: Boolean = true,
) {
    val spacing = LocalSpacing.current
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = exchangeItem.icon),
            contentDescription = exchangeItem.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(iconSize)
                .clip(RoundedCornerShape(topStart = 5.dp))
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        ) {
            Text(
                text = exchangeItem.name,
                style = titleStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.clickable {
                    uriHandler.openUri(exchangeItem.webSite)
                },
                text = exchangeItem.webSite,
                style = subTitleStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        if(isIconVisible) {
            Image(
                painter = painterResource(id = R.drawable.baseline_chevron_right_24),
                contentDescription = exchangeItem.name,
            )
        }
    }
}