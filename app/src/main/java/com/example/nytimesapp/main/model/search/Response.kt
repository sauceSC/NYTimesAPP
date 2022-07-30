package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(
    val docs: List<Doc>?,
    val meta: Meta
): Parcelable