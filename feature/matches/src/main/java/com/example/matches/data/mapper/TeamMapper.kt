package com.example.matches.data.mapper

import com.example.matches.domain.models.Match
import com.example.matches.domain.models.Matches
import com.example.teamservice.MatchesResponse

fun MatchesResponse.convert() =
    Matches(upcoming = matches.upcoming.map { match ->
        Match(
            date = match.date,
            description = match.description,
            home = match.home,
            away = match.away,
            winner = match.winner,
            highlights = match.highlights
        )
    },
        previous = matches.previous.map { match ->
            Match(
                date = match.date,
                description = match.description,
                home = match.home,
                away = match.away,
                winner = match.winner,
                highlights = match.highlights
            )
        }
    )

