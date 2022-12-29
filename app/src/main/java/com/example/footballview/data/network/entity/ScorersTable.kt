package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScorersTable(
    @SerialName("count")
    val count: Int?,
    @SerialName("filters")
    val filters: Filters?,
    @SerialName("competition")
    val competition: Competition?,
    @SerialName("season")
    val season: Season?,
    @SerialName("scorers")
    val scorers: List<Scorer>?
)