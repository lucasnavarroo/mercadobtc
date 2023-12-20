package com.example.mercadobitcoin

val validExchangesResponse = """ [
    {
        "exchange_id": "BINANCE",
        "website": "https://www.binance.com/",
        "name": "Binance",
        "data_quote_start": "2017-12-18T00:00:00.0000000Z",
        "data_quote_end": "2023-12-14T00:00:00.0000000Z",
        "data_orderbook_start": "2017-12-18T21:50:58.3910192Z",
        "data_orderbook_end": "2023-07-07T00:00:00.0000000Z",
        "data_trade_start": "2017-07-14T00:00:00.0000000Z",
        "data_trade_end": "2023-12-14T00:00:00.0000000Z",
        "data_symbols_count": 2419,
        "volume_1hrs_usd": 272122300.02,
        "volume_1day_usd": 9459105056.74,
        "volume_1mth_usd": 366086358066.52
    },
    {
        "exchange_id": "KRAKEN",
        "website": "https://www.kraken.com/",
        "name": "Kraken",
        "data_quote_start": "2014-07-31T00:00:00.0000000Z",
        "data_quote_end": "2023-12-14T00:00:00.0000000Z",
        "data_orderbook_start": "2014-07-31T13:05:46.0000000Z",
        "data_orderbook_end": "2023-07-06T00:00:00.0000000Z",
        "data_trade_start": "2013-10-22T00:00:00.0000000Z",
        "data_trade_end": "2023-12-14T00:00:00.0000000Z",
        "data_symbols_count": 862,
        "volume_1hrs_usd": 24379661.71,
        "volume_1day_usd": 486927444.02,
        "volume_1mth_usd": 28880533422.59
    },
    {
        "exchange_id": "COINBASE",
        "website": "https://pro.coinbase.com/",
        "name": "Coinbase Pro (GDAX)",
        "data_quote_start": "2015-05-17T00:00:00.0000000Z",
        "data_quote_end": "2023-12-14T00:00:00.0000000Z",
        "data_orderbook_start": "2015-05-17T00:51:32.6370000Z",
        "data_orderbook_end": "2023-07-06T00:00:00.0000000Z",
        "data_trade_start": "2015-01-14T00:00:00.0000000Z",
        "data_trade_end": "2023-12-14T00:00:00.0000000Z",
        "data_symbols_count": 682,
        "volume_1hrs_usd": 53995608.83,
        "volume_1day_usd": 1320803155.95,
        "volume_1mth_usd": 61669028262.22
    },
    {
        "exchange_id": "BITSTAMP",
        "website": "https://www.bitstamp.net/",
        "name": "Bitstamp Ltd.",
        "data_quote_start": "2014-02-24T00:00:00.0000000Z",
        "data_quote_end": "2023-12-14T00:00:00.0000000Z",
        "data_orderbook_start": "2014-02-24T17:43:05.0000000Z",
        "data_orderbook_end": "2023-07-06T00:00:00.0000000Z",
        "data_trade_start": "2011-09-13T00:00:00.0000000Z",
        "data_trade_end": "2023-12-14T00:00:00.0000000Z",
        "data_symbols_count": 209,
        "volume_1hrs_usd": 4419454.41,
        "volume_1day_usd": 90228037.49,
        "volume_1mth_usd": 5684136190.62
    }]
    """.trimIndent()