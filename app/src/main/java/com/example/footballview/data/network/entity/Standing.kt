package com.example.footballview.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Standing(
    @SerialName("stage")
    val stage: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("group")
    val group: String?,
    @SerialName("table")
    val table: List<Table?>?
)