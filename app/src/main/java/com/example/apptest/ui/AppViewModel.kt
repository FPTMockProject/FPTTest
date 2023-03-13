package com.example.apptest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptest.CalculateLocationInput
import com.example.apptest.CalculateLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    val calculateLocationUseCase: CalculateLocationUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(AppUiState(output = ""))
    val uiState: StateFlow<AppUiState> = _state

    fun onSubmitPressed(
        location: String,
        instruction: String,
    ) {
        viewModelScope.launch {
            val result = calculateLocationUseCase(CalculateLocationInput(location, instruction))
            _state.update { it.copy(output = result) }
        }
    }
}