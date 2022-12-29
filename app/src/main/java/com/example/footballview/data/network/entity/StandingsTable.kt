package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsTable(
    @SerialName("filters")
    val filters: Filters?,
    @SerialName("area")
    val area: Area?,
    @SerialName("competition")
    val competition: Competition?,
    @SerialName("season")
    val season: Season?,
    @SerialName("standings")
    val standings: List<Standing?>?
)