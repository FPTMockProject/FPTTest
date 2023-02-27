package com.example.matches.domain.models

data class Matches(
    val previous: List<Match> = emptyList(),
    val upcoming: List<Match> = emptyList(),
)
