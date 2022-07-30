package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Headline(
    val main: String?,
    val kicker: String?,
    val contentKicker: String?,
    val printHeadline: String?,
    val name: String?,
    val seo: String?,
    val sub: String?
): Parcelable