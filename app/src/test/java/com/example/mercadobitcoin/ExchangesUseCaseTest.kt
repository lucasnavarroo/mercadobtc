package com.example.mercadobitcoin

import com.example.mercadobitcoin.domain.model.Exchange
import com.example.mercadobitcoin.domain.repository.ExchangeRepository
import com.example.mercadobitcoin.domain.usecase.ExchangesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ExchangesUseCaseTest {

    private lateinit var exchangesUseCase: ExchangesUseCase
    val repository = mockk<ExchangeRepository>(relaxed = true)

    @Before
    fun setUp() {
        exchangesUseCase = ExchangesUseCase(repository)
    }

    @Test
    fun `it should get exchanges from repository successfully`() = runBlocking {
        val response: Result<List<Exchange>> = Result.success(emptyList())
        coEvery { repository.getExchanges() } returns response

        val getExchangesUseCase = exchangesUseCase.invoke()

        Assert.assertEquals(getExchangesUseCase, Result.success(emptyList<Exchange>()))
    }

    @Test
    fun `it should get exchanges from repository with failure`() = runBlocking {
        coEvery { repository.getExchanges() } throws Exception()

        val getExchangesUseCase = exchangesUseCase.invoke()

        Assert.assertEquals(getExchangesUseCase, Exception())
    }
}