package com.example.nytimesapp.main.api.model.search


import com.google.gson.annotations.SerializedName

data class SearchDocResponse(
    @SerializedName("abstract")
    val abstract: String?,
    @SerializedName("web_url")
    val webUrl: String?,
    @SerializedName("snippet")
    val snippet: String?,
    @SerializedName("lead_paragraph")
    val leadParagraph: String?,
    @SerializedName("print_section")
    val printSection: String?,
    @SerializedName("print_page")
    val printPage: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("multimedia")
    val multimedia: List<SearchMultimediaResponse>?,
    @SerializedName("headline")
    val headline: SearchHeadlineResponse?,
    @SerializedName("keywords")
    val keywords: List<SearchKeywordResponse>?,
    @SerializedName("pub_date")
    val pubDate: String?,
    @SerializedName("document_type")
    val documentType: String?,
    @SerializedName("news_desk")
    val newsDesk: String?,
    @SerializedName("section_name")
    val sectionName: String?,
    @SerializedName("subsection_name")
    val subsectionName: String?,
    @SerializedName("byline")
    val byline: SearchBylineResponse?,
    @SerializedName("type_of_material")
    val typeOfMaterial: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("word_count")
    val wordCount: Int?,
    @SerializedName("uri")
    val uri: String?
)