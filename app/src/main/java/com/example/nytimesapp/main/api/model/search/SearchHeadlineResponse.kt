package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchHeadlineResponse(
    @SerializedName("main")
    val main: String?,
    @SerializedName("kicker")
    val kicker: String?,
    @SerializedName("content_kicker")
    val contentKicker: String?,
    @SerializedName("print_headline")
    val printHeadline: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("seo")
    val seo: String?,
    @SerializedName("sub")
    val sub: String?
)