package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchMetaResponse(
    @SerializedName("hits")
    val hits: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("time")
    val time: Int?
)