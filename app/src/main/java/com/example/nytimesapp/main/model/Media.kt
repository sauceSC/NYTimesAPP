package com.example.nytimesapp.main.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Media(
    val type: String?,
    val subtype: String?,
    val caption: String?,
    val copyright: String?,
    val approvedForSyndication: Int?,
    val mediaMetadata: List<MediaMetadata>?
) : Parcelable