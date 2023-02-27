package com.example.teamservice

import java.util.*

data class MatchesResponse(
    val matches: Matches,
)

data class Match(
    val date: Date,
    val description: String,
    val home: String,
    val away: String,
    val winner: String? = null,
    val highlights: String? = null,
)

data class Matches(
    val previous: List<Match> = emptyList(),
    val upcoming: List<Match> = emptyList(),
)
