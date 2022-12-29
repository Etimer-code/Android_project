package com.example.footballview.data

import com.example.footballview.data.network.FootballViewAPI
import com.example.footballview.domain.StandingsTableRepository
import com.example.footballview.domain.entity.FootballPlayer
import com.example.footballview.domain.entity.StrTable

class StandingsTableRepositoryImpl(
    private val footballViewAPI : FootballViewAPI,
) : StandingsTableRepository {

    override suspend fun getStandingsTable(competition_id: String): List<StrTable> {
        val response = footballViewAPI.getStandingsTable(competition_id)
        val standing = response.standings?.get(0)

        return standing?.table?.mapNotNull {
            StrTable(
                TeamName = it?.team?.name ?: return@mapNotNull null,
                TeamPosition = it.position ?: return@mapNotNull null,
                TeamPosterUrl = it.team.crest ?: return@mapNotNull null,
                TeamPoints = it.points ?: return@mapNotNull null
            )
        } ?: emptyList()
    }

    override suspend fun getScorersTable(competition_id: String): List<FootballPlayer> {
        val response = footballViewAPI.getScorersTable(competition_id)

        return response.scorers?.mapNotNull {
            FootballPlayer(
                TeamName = it.team?.name ?: return@mapNotNull null,
                FootballPlayerName = it.player?.name ?: return@mapNotNull null,
                FootballPlayerGoals = it.goals ?: return@mapNotNull null
            )
        } ?: emptyList()
    }
}