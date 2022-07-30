package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val firstname: String?,
    val middlename: String?,
    val lastname: String?,
    val qualifier: String?,
    val title: String?,
    val role: String?,
    val organization: String?,
    val rank: Int?
): Parcelable