package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("code")
    val code: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("emblem")
    val emblem: String?
)