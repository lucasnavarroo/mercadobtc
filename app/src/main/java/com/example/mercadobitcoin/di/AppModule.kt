package com.example.mercadobitcoin.di

import com.example.mercadobitcoin.di.modules.apiModule
import com.example.mercadobitcoin.di.modules.repositoriesModule
import com.example.mercadobitcoin.di.modules.useCasesModule
import com.example.mercadobitcoin.di.modules.viewModelsModule

val appModules = listOf(
    apiModule,
    repositoriesModule,
    viewModelsModule,
    useCasesModule
)