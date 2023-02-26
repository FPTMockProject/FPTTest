package com.example.participationteam.presenter.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.participationteam.domain.usecases.GetTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParticipatingTeamViewModel @Inject constructor(private val getTeamsUseCase: GetTeamsUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow(ParticipatingTeamUiState())
    val uiState = _uiState.asLiveData()

    init {
        viewModelScope.launch {
            getTeamsUseCase(Unit).collect { teams ->
                _uiState.update { state -> state.copy(teams = teams) }
            }
        }
    }
}