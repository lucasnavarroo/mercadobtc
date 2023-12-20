package com.example.exchanges_data.di

import com.example.exchanges_data.remote.ExchangeAPI.Companion.BASE_URL
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

fun provideExchangeApi(client: OkHttpClient): com.example.exchanges_data.remote.ExchangeAPI {
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
