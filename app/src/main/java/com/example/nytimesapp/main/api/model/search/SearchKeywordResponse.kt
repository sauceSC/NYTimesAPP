package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchKeywordResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("major")
    val major: String?
)