package com.example.matches.domain.models

import java.util.Date

data class Match(
    val date: Date,
    val description: String,
    val home: String,
    val away: String,
    val winner: String? = null,
    val highlights: String? = null,
)
