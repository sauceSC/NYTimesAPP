package com.example.nytimesapp.main.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class News(
    val status: String?,
    val copyright: String?,
    val numResults: Int?,
    val results: List<ViewedArticle>?
) : Parcelable