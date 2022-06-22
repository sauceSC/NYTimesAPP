package com.example.nytimesapp.main.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ViewedArticle(
    val uri: String?,
    val url: String?,
    val id: Long?,
    val assetId: Long?,
    val source: String?,
    val publishedDate: String?,
    val updated: String?,
    val section: String?,
    val subsection: String?,
    val nytdsection: String?,
    val adxKeywords: String?,
    val column: String?,
    val byline: String?,
    val type: String?,
    val title: String?,
    val `abstract`: String?,
    val desFacet: List<String>?,
    val orgFacet: List<String>?,
    val perFacet: List<String>?,
    val geoFacet: List<String>?,
    val media: List<Media>?,
    val etaId: Int?
) : Parcelable