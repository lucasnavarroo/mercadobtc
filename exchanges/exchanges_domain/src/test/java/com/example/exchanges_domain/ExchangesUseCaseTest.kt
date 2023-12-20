package com.example.exchanges_domain

import com.example.exchanges_domain.model.Exchange
import com.example.exchanges_domain.repository.ExchangeRepository
import com.example.exchanges_domain.usecase.ExchangesUseCase
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
}