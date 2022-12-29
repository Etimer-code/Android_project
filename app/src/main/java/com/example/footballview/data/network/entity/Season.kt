package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Season(
    @SerialName("id")
    val id: Int?,
    @SerialName("startDate")
    val startDate: String?,
    @SerialName("endDate")
    val endDate: String?,
    @SerialName("currentMatchday")
    val currentMatchday: Int?,
    @SerialName("winner")
    val winner: String?
)