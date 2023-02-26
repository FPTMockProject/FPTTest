package com.example.participationteam.presenter.screen

import com.example.participationteam.domain.models.Team

data class ParticipatingTeamUiState(
    val teams: List<Team> = emptyList()
)
