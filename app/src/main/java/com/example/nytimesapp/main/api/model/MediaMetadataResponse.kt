package com.example.nytimesapp.main.api.model


import com.google.gson.annotations.SerializedName

data class MediaMetadataResponse(
    @SerializedName("url")
    val url: String?,
    @SerializedName("format")
    val format: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("width")
    val width: Int?
)