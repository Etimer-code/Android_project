package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("firstName")
    val firstName: String?,
    @SerialName("lastName")
    val lastName: String?,
    @SerialName("dateOfBirth")
    val dateOfBirth: String?,
    @SerialName("nationality")
    val nationality: String?,
    @SerialName("position")
    val position: String?,
    @SerialName("shirtNumber")
    val shirtNumber: String?,
    @SerialName("lastUpdated")
    val lastUpdated: String?
)