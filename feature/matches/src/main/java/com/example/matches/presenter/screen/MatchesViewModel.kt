package com.example.matches.presenter.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.matches.domain.models.Matches
import com.example.matches.domain.usecases.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MatchesUiState(Matches()))
    val uiState = _uiState.asLiveData()

    init {
        viewModelScope.launch {
            getMatchesUseCase(Unit).collect { matches ->
                _uiState.update { state -> state.copy(matches = matches) }
            }
        }
    }
}