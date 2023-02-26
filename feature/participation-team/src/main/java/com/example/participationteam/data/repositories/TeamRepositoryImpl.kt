package com.example.participationteam.data.repositories

import com.example.participationteam.data.services.TeamService
import com.example.participationteam.domain.models.Team
import com.example.participationteam.domain.repositories.TeamRepository
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(private val teamService: TeamService) :
    TeamRepository {
    override suspend fun getTeams(): List<Team> {
        val response = teamService.getTeams()
        return response.body()!!.teams
    }
}