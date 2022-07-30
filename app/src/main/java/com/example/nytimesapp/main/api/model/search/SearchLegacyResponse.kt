package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchLegacyResponse(
    @SerializedName("xlarge")
    val xlarge: String?,
    @SerializedName("xlargewidth")
    val xlargewidth: Int?,
    @SerializedName("xlargeheight")
    val xlargeheight: Int?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("thumbnailwidth")
    val thumbnailwidth: Int?,
    @SerializedName("thumbnailheight")
    val thumbnailheight: Int?,
    @SerializedName("widewidth")
    val widewidth: Int?,
    @SerializedName("wideheight")
    val wideheight: Int?,
    @SerializedName("wide")
    val wide: String?
)