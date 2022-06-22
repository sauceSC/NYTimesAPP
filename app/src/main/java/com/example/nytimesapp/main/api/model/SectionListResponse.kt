package com.example.nytimesapp.main.api.model


import com.google.gson.annotations.SerializedName

data class SectionListResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val section: List<SectionResponse>?
)