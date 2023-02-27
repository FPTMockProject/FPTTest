package com.example.matches.data.services

import com.example.matches.data.dto.MatchesDto
import com.example.network.RetrofitHelper
import retrofit2.Response
import retrofit2.http.GET

interface MatchService {
    @GET("/teams/matches")
    suspend fun getMatches(): Response<MatchesDto>

    companion object {
        private const val BASE_URL = "https://jmde6xvjr4.execute-api.us-east-1.amazonaws.com/"

        fun create(): MatchService {
            return RetrofitHelper.getInstance(BASE_URL)
                .create(MatchService::class.java)
        }
    }
}