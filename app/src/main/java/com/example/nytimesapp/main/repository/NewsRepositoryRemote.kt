package com.example.nytimesapp.main.repository

import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionListResponse

interface NewsRepositoryRemote {
    suspend fun getNews(period: Int): NewsResponse

    suspend fun getSections(): SectionListResponse


}