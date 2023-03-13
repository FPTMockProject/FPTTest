package com.example.apptest

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class CalculateLocationUseCaseTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given location 12N and movement LMLMLMLMM, should return location 13N`() =
        runTest {
            // given
            val dispatcher = StandardTestDispatcher(testScheduler)
            val useCase = CalculateLocationUseCaseImpl(dispatcher)
            // when
            val result = useCase(CalculateLocationInput("12N", "LMLMLMLMM"))
            // then
            assertEquals(result, "13N")
        }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given location 33E and movement MMRMMRMRRM, should return location 51E`() = runTest {
        // given
        val dispatcher = StandardTestDispatcher(testScheduler)
        val useCase = CalculateLocationUseCaseImpl(dispatcher)
        // when
        val result = useCase(CalculateLocationInput("33E", "MMRMMRMRRM"))
        // then
        assertEquals(result, "51E")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given location 55N and movement MMRMMLLMRMLLM, should return location 44S`() = runTest {
        // given
        val dispatcher = StandardTestDispatcher(testScheduler)
        val useCase = CalculateLocationUseCaseImpl(dispatcher)
        // when
        val result = useCase(CalculateLocationInput("55N", "MMRMMLLMRMLLM"))
        // then
        assertEquals(result, "44S")
    }
}