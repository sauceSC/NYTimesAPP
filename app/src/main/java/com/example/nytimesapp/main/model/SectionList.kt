package com.example.nytimesapp.main.model

import android.os.Parcelable
import com.example.nytimesapp.main.api.model.SectionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class SectionList(
    val status: String?,
    val copyright: String?,
    val numResults: Int?,
    val section: List<Section>
): Parcelable
