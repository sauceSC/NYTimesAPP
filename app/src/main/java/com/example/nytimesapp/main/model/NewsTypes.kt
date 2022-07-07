package com.example.nytimesapp.main.model

import android.os.Parcelable
import com.example.nytimesapp.main.api.model.MediaResponse
import kotlinx.parcelize.Parcelize

sealed class NewsTypes: Parcelable{
    abstract val type: Int

    @Parcelize
    data class BigImageArticle(
        val section: String?,
        val title: String?,
        val abstract: String?,
        val publishedDate: String?,
        val media: List<Media>,
        override val type: Int = 2
    ) : NewsTypes()

    @Parcelize
    data class SmallImageArticle(
        val section: String?,
        val title: String?,
        val abstract: String?,
        val publishedDate: String?,
        val media: List<Media>?,
        override val type: Int = 3
    ) : NewsTypes()
}
