package com.example.participationteam.data.services

import com.example.network.RetrofitHelper
import com.example.participationteam.data.dto.TeamDto
import com.example.participationteam.domain.models.Team
import retrofit2.Response
import retrofit2.http.GET

interface TeamService {
    @GET("/teams")
    suspend fun getTeams(): Response<TeamDto>

    companion object {
        private const val BASE_URL = "https://jmde6xvjr4.execute-api.us-east-1.amazonaws.com/"

        fun create(): TeamService {
            return RetrofitHelper.getInstance(BASE_URL)
                .create(TeamService::class.java)
        }
    }
}