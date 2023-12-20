package com.example.exchanges_data.remote

import com.google.gson.annotations.SerializedName


data class ExchangeDTO(
    @SerializedName("exchange_id")
    val exchangeId: String? = null,
    @SerializedName("website")
    val webSite: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("data_quote_start")
    val dataQuoteStart: String? = null,
    @SerializedName("data_quote_end")
    val dataQuoteEnd: String? = null,
    @SerializedName("data_orderbook_start")
    val dataOrderbookStart: String? = null,
    @SerializedName("data_orderbook_end")
    val dataOrderbookEnd: String? = null,
    @SerializedName("data_trade_start")
    val dataTradeStart: String? = null,
    @SerializedName("data_trade_end")
    val dataTradeEnd: String? = null,
    @SerializedName("data_symbols_count")
    val dataSymbolsCount: Int? = null,
    @SerializedName("volume_1hrs_usd")
    val volumeOneHrsUsd: Double? = null,
    @SerializedName("volume_1day_usd")
    val volumeOneDayUsd: Double? = null,
    @SerializedName("volume_1mth_usd")
    val volumeOneMthUsd: Double? = null,
)
