package com.example.mercadobitcoin.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ExchangeTextInfo(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    style: TextStyle = MaterialTheme.typography.body1.copy(color = Color.Gray, fontWeight = FontWeight.Bold)
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = style,
        )
        Text(
            text = value,
        )
    }
}