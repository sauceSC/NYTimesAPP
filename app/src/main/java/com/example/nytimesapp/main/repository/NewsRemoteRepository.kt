package com.example.nytimesapp.main.repository

import com.example.nytimesapp.main.api.NYTimesAPI
import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionListResponse
import com.example.nytimesapp.utils.Constants

class NewsRemoteRepository(val api: NYTimesAPI) : NewsRepositoryRemote {

    override suspend fun getNews(period: Int): NewsResponse = when(period){
        Constants.ONE_DAY -> api.getNewsToday(Constants.API_KEY)
        Constants.ONE_WEEK -> api.getNewsWeek(Constants.API_KEY)
        Constants.ONE_MONTH -> api.getNewsMonth(Constants.API_KEY)
        else -> throw IllegalArgumentException("wrong period argument: $period")
    }

    override suspend fun getSections(): SectionListResponse {
        val data = api.getNewsSection(Constants.API_KEY)
        return data
    }


}