package com.example.matches.data.repositories

import com.example.matches.data.mapper.convert
import com.example.matches.domain.models.Matches
import com.example.matches.domain.repositories.MatchesRepository
import com.example.teamservice.TeamService
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val matchService: TeamService
) : MatchesRepository {
    override suspend fun getMatches(): Matches {
        val response = matchService.getMatches()
        return response.body()!!.convert()
    }
}