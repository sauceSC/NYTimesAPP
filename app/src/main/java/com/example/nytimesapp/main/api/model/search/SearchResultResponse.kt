package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("docs")
    val docs: List<SearchDocResponse>?,
    @SerializedName("meta")
    val meta: SearchMetaResponse?
)