package com.example.footballview.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class FootballPlayer(
    val TeamName : String?,
    val FootballPlayerName : String?,
    val FootballPlayerGoals : Int?,
) : Parcelable