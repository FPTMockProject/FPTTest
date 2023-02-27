package com.example.teamservice

data class TeamResponse(
    val teams: List<Team>
)

data class Team(
    val id: String,
    val name: String,
    val logo: String,
)

