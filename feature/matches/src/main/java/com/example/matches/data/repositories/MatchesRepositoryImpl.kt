package com.example.matches.data.repositories

import com.example.matches.data.services.MatchService
import com.example.matches.domain.models.Matches
import com.example.matches.domain.repositories.MatchesRepository
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val matchService: MatchService
) : MatchesRepository {
    override suspend fun getMatches(): Matches {
        val response = matchService.getMatches()
        return response.body()!!.matches
    }
}