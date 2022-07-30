package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Byline(
    val original: String?,
    val person: List<Person>?,
    val organization: String?
):Parcelable