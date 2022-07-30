package com.example.nytimesapp.main.model.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doc(
    val abstract: String?,
    val webUrl: String?,
    val snippet: String?,
    val leadParagraph: String?,
    val printSection: String?,
    val printPage: String?,
    val source: String?,
    val multimedia: List<Multimedia>?,
    val headline: Headline,
    val keywords: List<Keyword>?,
    val pubDate: String?,
    val documentType: String?,
    val newsDesk: String?,
    val sectionName: String?,
    val subsectionName: String?,
    val byline: Byline,
    val typeOfMaterial: String?,
    val id: String?,
    val wordCount: Int?,
    val uri: String?
): Parcelable