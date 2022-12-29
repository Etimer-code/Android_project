package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Scorer(
    @SerialName("player")
    val player: Player?,
    @SerialName("team")
    val team: Team?,
    @SerialName("goals")
    val goals: Int?,
    @SerialName("assists")
    val assists: Int?,
    @SerialName("penalties")
    val penalties: Int?
)