package com.example.teamservice

import com.example.network.RetrofitHelper
import retrofit2.Response
import retrofit2.http.GET

interface TeamService {

    @GET("/teams/matches")
    suspend fun getMatches(): Response<MatchesResponse>
    @GET("/teams")
    suspend fun getTeams(): Response<TeamResponse>

    companion object {
        private const val BASE_URL = "https://jmde6xvjr4.execute-api.us-east-1.amazonaws.com/"

        fun create(): TeamService {
            return RetrofitHelper.getInstance(BASE_URL)
                .create(TeamService::class.java)
        }
    }
}