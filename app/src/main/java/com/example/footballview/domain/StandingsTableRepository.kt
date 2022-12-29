package com.example.footballview.domain

import com.example.footballview.domain.entity.FootballPlayer
import com.example.footballview.domain.entity.StrTable

interface StandingsTableRepository {
    suspend fun getStandingsTable(competition_id: String) : List<StrTable>

    suspend fun getScorersTable(competition_id: String): List<FootballPlayer>
}