package com.example.nytimesapp.main.interactor

import com.example.nytimesapp.main.model.News
import com.example.nytimesapp.main.model.SectionList
import com.example.nytimesapp.main.model.search.Search
import com.example.nytimesapp.main.repository.NewsRemoteRepository

class NewsInteractor(private val newsRemoteRepository: NewsRemoteRepository) {

    suspend fun getNewsResults(period: Int): News {
        return newsRemoteRepository.getNews(period)
    }

    suspend fun getSectionResults() : SectionList {
        return newsRemoteRepository.getSections()
    }

    suspend fun getNewsBySections(section: String) : Search {
        return newsRemoteRepository.getNewsBySections(section)
    }
}