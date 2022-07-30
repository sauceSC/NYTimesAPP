package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Keyword(
    val name: String?,
    val value: String?,
    val rank: Int?,
    val major: String?
): Parcelable