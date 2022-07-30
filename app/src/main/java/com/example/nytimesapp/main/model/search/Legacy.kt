package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Legacy(
    val xlarge: String?,
    val xlargewidth: Int?,
    val xlargeheight: Int?,
    val thumbnail: String?,
    val thumbnailwidth: Int?,
    val thumbnailheight: Int?,
    val widewidth: Int?,
    val wideheight: Int?,
    val wide: String?
): Parcelable