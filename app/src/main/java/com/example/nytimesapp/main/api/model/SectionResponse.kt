package com.example.nytimesapp.main.api.model


import com.example.nytimesapp.common.basemvp.Item
import com.google.gson.annotations.SerializedName

data class SectionResponse(
    @SerializedName("section")
    val section: String?,
    @SerializedName("display_name")
    val displayName: String?
) : Item