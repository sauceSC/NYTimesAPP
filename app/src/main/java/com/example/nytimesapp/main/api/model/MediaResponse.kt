package com.example.nytimesapp.main.api.model


import com.google.gson.annotations.SerializedName

data class MediaResponse(
    @SerializedName("type")
    val type: String?,
    @SerializedName("subtype")
    val subtype: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int?,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataResponse>?
)