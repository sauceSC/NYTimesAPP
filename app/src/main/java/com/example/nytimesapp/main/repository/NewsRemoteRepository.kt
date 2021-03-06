package com.example.nytimesapp.main.repository

import com.example.nytimesapp.main.api.NYTimesAPI
import com.example.nytimesapp.main.converter.Converter
import com.example.nytimesapp.main.model.News
import com.example.nytimesapp.main.model.SectionList
import com.example.nytimesapp.main.model.search.Search
import com.example.nytimesapp.utils.Constants
import timber.log.Timber

class NewsRemoteRepository(val api: NYTimesAPI) : NewsRepositoryRemote {

    override suspend fun getNews(period: Int): News = when(period){
        Constants.ONE_DAY -> Converter.newsFromNetwork(api.getNewsToday(Constants.API_KEY))
        Constants.ONE_WEEK -> Converter.newsFromNetwork(api.getNewsWeek(Constants.API_KEY))
        Constants.ONE_MONTH -> Converter.newsFromNetwork(api.getNewsMonth(Constants.API_KEY))
        else -> throw IllegalArgumentException("wrong period argument: $period")
    }

    override suspend fun getSections(): SectionList {
        val data = api.getNewsSection(Constants.API_KEY)
        return Converter.sectionFromNetwork(data)
    }

    override suspend fun getNewsBySections(section: String): Search {
        val data = api.getNewsBySection(section, Constants.API_KEY)
        return Converter.newsBySections(data)
    }


}