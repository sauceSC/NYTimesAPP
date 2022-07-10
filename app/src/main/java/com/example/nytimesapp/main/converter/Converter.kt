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
        results = response.results?.let { newsFromNetwork(it) }
    )

    private fun newsFromNetwork(response: List<ViewedArticleResponse>) : List<ViewedArticle> {
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
        return response?.map {
            Media(
                type = it.type,
                subtype = it.subtype,
                caption = it.caption,
                copyright = it.copyright,
                approvedForSyndication = it.approvedForSyndication,
                mediaMetadata = mediaMetadataFromNetwork(it.mediaMetadata)
            )
        }!!
    }

    private fun mediaMetadataFromNetwork(response: List<MediaMetadataResponse>?): List<MediaMetadata> {
        return response?.map {
            MediaMetadata(
                url = it.url,
                format = it.format,
                height = it.height,
                width = it.width
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