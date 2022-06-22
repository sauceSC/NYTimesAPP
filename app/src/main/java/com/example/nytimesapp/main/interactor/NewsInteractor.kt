package com.example.nytimesapp.main.interactor

import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionListResponse
import com.example.nytimesapp.main.repository.NewsRemoteRepository
import timber.log.Timber

class NewsInteractor(private val newsRemoteRepository: NewsRemoteRepository) {

    suspend fun getNewsResults(period: Int): NewsResponse {
        return newsRemoteRepository.getNews(period)
    }

    suspend fun getSectionResults() : SectionListResponse{
        return newsRemoteRepository.getSections()
    }
}