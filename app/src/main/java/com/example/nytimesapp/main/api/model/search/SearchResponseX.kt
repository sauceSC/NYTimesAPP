package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchResponseX(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("response")
    val response: SearchResultResponse?
)