package com.example.mercadobitcoin

import android.annotation.SuppressLint
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.theme.MercadoBitcoinTheme
import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_domain.usecase.ExchangesUseCase
import com.example.exchanges_presentation.details.ExchangeDetailsScreen
import com.example.exchanges_presentation.list.model.ExchangeUI
import com.example.exchanges_presentation.list.view.ExchangeScreen
import com.example.exchanges_presentation.list.viewmodel.ExchangeViewModel
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExchangeScreenUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var exchangeRepository: ExchangeRepositoryFake
    private lateinit var exchangeUseCase: ExchangesUseCase
    private lateinit var exchangeViewModel: ExchangeViewModel
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Before
    fun setUp() {
        exchangeRepository = ExchangeRepositoryFake()
        exchangeUseCase = ExchangesUseCase(exchangeRepository)
        exchangeViewModel = ExchangeViewModel(exchangeUseCase)

        composeRule.activity.setContent {
            MercadoBitcoinTheme {
                navController = rememberNavController()
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

    @Test
    fun performUiTests() {
        exchangeRepository.exchangesResult = listOf(
            Exchange(
                "1",
                "binance",
                "binance",
                100.0,
                1000.0,
                10000.0
            )
        )

        composeRule
            .onNodeWithText("Exchanges")
            .assertExists()
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("exchange_item")
            .assertExists()
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("loading_box")
            .assertExists()
            .assertIsDisplayed()

        composeRule
            .onNodeWithContentDescription("binance")
            .assertIsDisplayed()

        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.EXCHANGES)
        ).isTrue()

        composeRule
            .onNodeWithContentDescription("binance")
            .performClick()

        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.EXCHANGE_DETAILS)
        ).isTrue()

        composeRule
            .onNodeWithTag("exchange_details_screen")
            .assertExists()
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("icon_back")
            .assertExists()
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("icon_back")
            .performClick()

        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.EXCHANGES)
        ).isTrue()
    }
}