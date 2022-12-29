package com.example.footballview.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class StrTable(
    val TeamName : String?,
    val TeamPosition : Int?,
    val TeamPosterUrl : String?,
    val TeamPoints : Int?,
) : Parcelable