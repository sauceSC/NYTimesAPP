package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchBylineResponse(
    @SerializedName("original")
    val original: String?,
    @SerializedName("person")
    val person: List<SearchPersonResponse>?,
    @SerializedName("organization")
    val organization: String?
)