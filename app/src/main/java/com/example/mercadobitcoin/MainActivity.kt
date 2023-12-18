package com.example.mercadobitcoin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mercadobitcoin.di.appModules
import com.example.mercadobitcoin.presentation.list.viewmodel.ExchangeViewModel
import com.example.mercadobitcoin.core.theme.MercadoBitcoinTheme
import com.example.mercadobitcoin.presentation.details.ExchangeDetailsScreen
import com.example.mercadobitcoin.presentation.list.model.ExchangeUI
import com.example.mercadobitcoin.presentation.list.view.ExchangeScreen
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

        val exchangeViewModel : ExchangeViewModel by viewModel()

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
                            val exchangeJson =  backStackEntry.arguments?.getString("exchange")
                            val exchangeObject = Gson().fromJson(exchangeJson, ExchangeUI::class.java)
                            ExchangeDetailsScreen(exchangeObject) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MercadoBitcoinTheme {
        Greeting("Android")
    }
}