package com.example.participationteam.data.mapper

import com.example.participationteam.domain.models.Team
import com.example.teamservice.TeamResponse

fun TeamResponse.convert(): List<Team> {
    return teams.map { team -> Team(team.id, team.name, team.logo) }
}

