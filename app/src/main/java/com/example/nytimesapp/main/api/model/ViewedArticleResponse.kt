package com.example.nytimesapp.main.api.model


import com.example.nytimesapp.common.basemvp.Item
import com.google.gson.annotations.SerializedName

data class ViewedArticleResponse(
    @SerializedName("uri")
    val uri: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("asset_id")
    val assetId: Long?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("section")
    val section: String?,
    @SerializedName("subsection")
    val subsection: String?,
    @SerializedName("nytdsection")
    val nytdsection: String?,
    @SerializedName("adx_keywords")
    val adxKeywords: String?,
    @SerializedName("column")
    val column: String?,
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("abstract")
    val abstract: String?,
    @SerializedName("des_facet")
    val desFacet: List<String>?,
    @SerializedName("org_facet")
    val orgFacet: List<String>?,
    @SerializedName("per_facet")
    val perFacet: List<String>?,
    @SerializedName("geo_facet")
    val geoFacet: List<String>?,
    @SerializedName("media")
    val media: List<MediaResponse>?,
    @SerializedName("eta_id")
    val etaId: Int?
) : Item