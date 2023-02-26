package com.example.participationteam.domain.repositories

import com.example.participationteam.domain.models.Team

interface TeamRepository {
    suspend fun getTeams(): List<Team>
}