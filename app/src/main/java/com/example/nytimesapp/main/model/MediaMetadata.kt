package com.example.nytimesapp.main.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MediaMetadata(
    val url: String?,
    val format: String?,
    val height: Int?,
    val width: Int?
) : Parcelable