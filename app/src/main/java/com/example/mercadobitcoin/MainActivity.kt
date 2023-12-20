package com.example.mercadobitcoin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.theme.MercadoBitcoinTheme
import com.example.exchanges_presentation.details.ExchangeDetailsScreen
import com.example.exchanges_presentation.list.model.ExchangeUI
import com.example.exchanges_presentation.list.view.ExchangeScreen
import com.example.exchanges_presentation.list.viewmodel.ExchangeViewModel
import com.example.mercadobitcoin.di.appModules
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalContext.startKoin {
            androidContext(this@MainActivity)
            modules(appModules)
        }

        val exchangeViewModel: ExchangeViewModel by viewModel()

        setContent {
            MercadoBitcoinTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.EXCHANGES
                    ) {
                        composable(Route.EXCHANGES) {
                            ExchangeScreen(
                                onDetailsClick = { exchangeJson ->
                                    navController.navigate(
                                        Route.EXCHANGE_DETAILS.replace("{exchange}", exchangeJson)
                                    )
                                },
                                scaffoldState = scaffoldState,
                                viewModel = exchangeViewModel,
                            )
                        }
                        composable(Route.EXCHANGE_DETAILS) { backStackEntry ->
                            val exchangeJson = backStackEntry.arguments?.getString("exchange")
                            val exchangeObject =
                                Gson().fromJson(exchangeJson, ExchangeUI::class.java)
                            ExchangeDetailsScreen(
                                exchangeObject
                            ) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}