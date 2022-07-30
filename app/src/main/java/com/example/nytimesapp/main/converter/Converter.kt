package com.example.nytimesapp.main.converter

import com.example.nytimesapp.main.api.model.*
import com.example.nytimesapp.main.api.model.search.*
import com.example.nytimesapp.main.model.*
import com.example.nytimesapp.main.model.search.*

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

    fun newsBySections(response: SearchResponseX) = Search(
        status = response.status,
        copyright = response.copyright,
        response = searchFromNetwork(response.response)
    )
}
    private fun searchFromNetwork(response: SearchResultResponse?) = Response(
        docs = docsFromNetwork(response?.docs),
        meta = searchFromNetwork(response?.meta)
    )
    private fun searchFromNetwork(response: SearchMetaResponse?) = Meta(
        hits = response?.hits,
        offset = response?.offset,
        time = response?.time
    )

    private fun docsFromNetwork(response: List<SearchDocResponse>?): List<Doc>?{
        return response?.map { searchFromNetwork(it) }
    }
    private fun searchFromNetwork(response: SearchDocResponse) = Doc(
        abstract = response.abstract,
        webUrl = response.webUrl,
        snippet = response.snippet,
        leadParagraph = response.leadParagraph,
        printPage = response.printPage,
        printSection = response.printSection,
        source = response.source,
        multimedia = searchFromNetwork(response.multimedia),
        headline = searchFromNetwork(response.headline),
        keywords = keywordFromNetwork(response.keywords),
        pubDate = response.pubDate,
        documentType = response.documentType,
        newsDesk = response.newsDesk,
        sectionName = response.sectionName,
        subsectionName = response.subsectionName,
        byline = searchFromNetwork(response.byline),
        typeOfMaterial = response.typeOfMaterial,
        id = response.id,
        wordCount = response.wordCount,
        uri = response.uri
    )

    private fun searchFromNetwork(response: SearchBylineResponse?) = Byline(
        original = response?.original,
        person = personFromNetwork(response?.person),
        organization = response?.organization
    )

    private fun personFromNetwork(response: List<SearchPersonResponse>?) : List<Person>?{
        return response?.map { searchFromNetwork(it) }
    }

    private fun searchFromNetwork(response: SearchPersonResponse) = Person(
        firstname = response.firstname,
        middlename = response.middlename,
        lastname = response.lastname,
        qualifier = response.qualifier,
        title = response.title,
        role = response.role,
        organization = response.organization,
        rank = response.rank
    )

    private fun keywordFromNetwork(response: List<SearchKeywordResponse>?) : List<Keyword>? {
        return response?.map { searchFromNetwork(it) }
    }

    private fun searchFromNetwork(response: SearchKeywordResponse) = Keyword(
        name = response.name,
        value = response.value,
        rank = response.rank,
        major = response.major
    )

    private fun searchFromNetwork(response: SearchHeadlineResponse?) = Headline(
        main = response?.main,
        kicker = response?.kicker,
        contentKicker = response?.contentKicker,
        printHeadline = response?.printHeadline,
        name = response?.name,
        seo = response?.seo,
        sub = response?.sub
    )

    private fun searchFromNetwork(response: List<SearchMultimediaResponse>?): List<Multimedia>? {
        return response?.map { searchFromNetwork(it) }
    }

    private fun searchFromNetwork(response: SearchMultimediaResponse) = Multimedia(
        rank = response.rank,
        subType = response.subType,
        subtype = response.subtype,
        caption = response.caption,
        credit = response.credit,
        type = response.type,
        url = response.url,
        height = response.height,
        width = response.width,
        legacy = searchFromNetwork(response.legacy),
        cropName = response.cropName
    )

    private fun searchFromNetwork(response: SearchLegacyResponse?) = Legacy(
        xlarge = response?.xlarge,
        xlargewidth = response?.xlargewidth,
        xlargeheight = response?.xlargeheight,
        thumbnail = response?.thumbnail,
        thumbnailwidth = response?.thumbnailwidth,
        thumbnailheight = response?.thumbnailheight,
        widewidth = response?.widewidth,
        wideheight = response?.wideheight,
        wide = response?.wide
    )

    private fun newsFromNetwork(response: List<ViewedArticleResponse>): List<ViewedArticle> {
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
