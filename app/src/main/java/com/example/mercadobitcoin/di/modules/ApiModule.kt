package com.example.mercadobitcoin.di.modules

import com.example.mercadobitcoin.data.remote.ExchangeAPI
import com.example.mercadobitcoin.data.remote.ExchangeAPI.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val apiModule = module {
    single { provideExchangeApi(get()) }
    single { provideOkHttpClient() }
}

fun provideExchangeApi(client: OkHttpClient): ExchangeAPI {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()
}
