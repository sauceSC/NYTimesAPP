package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Multimedia(
    val rank: Int?,
    val subtype: String?,
    val caption: String?,
    val credit: String?,
    val type: String?,
    val url: String?,
    val height: Int?,
    val width: Int?,
    val legacy: Legacy,
    val subType: String?,
    val cropName: String?
): Parcelable