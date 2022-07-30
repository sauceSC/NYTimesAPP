package com.example.nytimesapp.main.repository

import com.example.nytimesapp.main.model.News
import com.example.nytimesapp.main.model.SectionList
import com.example.nytimesapp.main.model.search.Search

interface NewsRepositoryRemote {
    suspend fun getNews(period: Int): News
    suspend fun getSections(): SectionList
    suspend fun getNewsBySections(section: String) : Search

}