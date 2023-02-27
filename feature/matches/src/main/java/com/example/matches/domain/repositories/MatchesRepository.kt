package com.example.matches.domain.repositories

import com.example.matches.domain.models.Matches

interface MatchesRepository {
    suspend fun getMatches(): Matches
}