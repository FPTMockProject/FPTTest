package com.example.apptest.ui

import app.cash.turbine.test
import com.example.apptest.CalculateLocationUseCaseImpl
import com.example.apptest.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
internal class AppViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `on submit button is pressed, verify use case is called`() = runTest {
        val useCase = CalculateLocationUseCaseImpl(UnconfinedTestDispatcher(testScheduler))
        val appViewModel = AppViewModel(useCase)
        appViewModel.onSubmitPressed("12N", "LMLMLMLMM")
        appViewModel.uiState.test {
            val uiState = awaitItem()
            assertEquals("13N", uiState.output)
        }
    }
}