package com.example.nytimesapp.main.repository

import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionListResponse
import com.example.nytimesapp.main.model.News
import com.example.nytimesapp.main.model.SectionList
import com.example.nytimesapp.main.model.ViewedArticle

interface NewsRepositoryRemote {
    suspend fun getNews(period: Int): News
    suspend fun getSections(): SectionList


}