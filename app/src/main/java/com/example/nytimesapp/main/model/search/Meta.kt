package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    val hits: Int?,
    val offset: Int?,
    val time: Int?
): Parcelable