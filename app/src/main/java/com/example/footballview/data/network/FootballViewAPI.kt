package com.example.footballview.data.network

import com.example.footballview.data.network.entity.ScorersTable
import com.example.footballview.data.network.entity.StandingsTable
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballViewAPI {
    @GET("/v4/competitions/{competition_id}/standings")
    suspend fun getStandingsTable(@Path("competition_id") competition_id: String): StandingsTable

    @GET("/v4/competitions/{competition_id}/scorers")
    suspend fun getScorersTable(@Path("competition_id") competition_id: String): ScorersTable
}
