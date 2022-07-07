package com.example.nytimesapp.main.converter

import com.example.nytimesapp.main.api.model.*
import com.example.nytimesapp.main.model.*

object Converter {
    fun sectionFromNetwork(response: SectionListResponse) = SectionList(
        status = response.status,
        copyright = response.copyright,
        numResults = response.numResults,
        section = sections(response.section)
    )

    fun newsFromNetwork(response: NewsResponse) = News(
        status = response.status,
        copyright = response.copyright,
        numResults = response.numResults,
        results = response.results?.let { Converter.newsFromNetwork(it) }
    )

    private fun toSmallImageNews(
        response: ViewedArticleResponse,
        type: Int
    ) = NewsTypes.SmallImageArticle(
        section = response.section,
        title = response.title,
        publishedDate = response.publishedDate,
        abstract = response.abstract,
        media = mediaFromNetwork(response.media ),
        type = type
    )

    private fun toBigImageNews(
        response: ViewedArticleResponse,
        type: Int
    ) = NewsTypes.BigImageArticle(
        section = response.section,
        title = response.title,
        publishedDate = response.publishedDate,
        abstract = response.abstract,
        media = mediaFromNetwork(response.media),
        type = type
    )
    fun newsFromNetwork(response: List<ViewedArticleResponse>) : List<ViewedArticle> {
        return response.map { newsFromNetwork(it) }
    }

    private fun newsFromNetwork(response: ViewedArticleResponse) = ViewedArticle(
        uri = response.uri,
        url = response.url,
        id = response.id,
        assetId = response.assetId,
        source = response.source,
        publishedDate = response.publishedDate,
        updated = response.updated,
        section = response.section,
        subsection = response.subsection,
        nytdsection = response.nytdsection,
        adxKeywords = response.adxKeywords,
        column = response.column,
        byline = response.byline,
        type = response.type,
        title = response.title,
        abstract = response.abstract,
        desFacet = response.desFacet,
        orgFacet = response.orgFacet,
        perFacet = response.perFacet,
        geoFacet = response.geoFacet,
        media = mediaFromNetwork(response.media),
        etaId = response.etaId
    )

    private fun mediaFromNetwork(response: List<MediaResponse>?): List<Media> {
        return response?.map { response ->
            Media(
                type = response.type,
                subtype = response.subtype,
                caption = response.caption,
                copyright = response.copyright,
                approvedForSyndication = response.approvedForSyndication,
                mediaMetadata = mediaMetadataFromNetwork(response.mediaMetadata)
            )
        }!!
    }

    private fun mediaMetadataFromNetwork(response: List<MediaMetadataResponse>?): List<MediaMetadata> {
        return response?.map { response ->
            MediaMetadata(
                url = response.url,
                format = response.format,
                height = response.height,
                width = response.width
            )
        }!!
    }

    private fun sections(response: List<SectionResponse>?): List<Section> {
        return response?.map { sectionsFromNetwork(it) }!!
    }

    private fun sectionsFromNetwork(response: SectionResponse) = Section(
        section = response.section,
        displayName = response.displayName
    )

}