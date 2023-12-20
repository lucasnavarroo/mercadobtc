package com.example.mercadobitcoin.di

import com.example.exchanges_data.di.apiModule
import com.example.exchanges_data.di.repositoriesModule
import com.example.exchanges_domain.di.useCasesModule
import com.example.mercadobitcoin.di.modules.viewModelsModule

val appModules = listOf(
    apiModule,
    repositoriesModule,
    viewModelsModule,
    useCasesModule
)