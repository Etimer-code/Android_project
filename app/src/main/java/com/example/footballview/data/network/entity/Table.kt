package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Table(
    @SerialName("position")
    val position: Int?,
    @SerialName("team")
    val team: Team?,
    @SerialName("playedGames")
    val playedGames: Int?,
    @SerialName("form")
    val form: String?,
    @SerialName("won")
    val won: Int?,
    @SerialName("draw")
    val draw: Int?,
    @SerialName("lost")
    val lost: Int?,
    @SerialName("points")
    val points: Int?,
    @SerialName("goalsFor")
    val goalsFor: Int?,
    @SerialName("goalsAgainst")
    val goalsAgainst: Int?,
    @SerialName("goalDifference")
    val goalDifference: Int?
)