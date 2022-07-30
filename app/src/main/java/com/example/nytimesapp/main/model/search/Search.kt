package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Search(
    val status: String?,
    val copyright: String?,
    val response: Response
): Parcelable