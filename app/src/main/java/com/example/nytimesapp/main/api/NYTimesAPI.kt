package com.example.nytimesapp.main.api

import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesAPI {
    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getNewsToday(
        @Query("api-key") apiKey: String
    ) : NewsResponse

    @GET("mostpopular/v2/viewed/7.json")
    suspend fun getNewsWeek(
        @Query("api-key") apiKey: String
    ) : NewsResponse

    @GET("mostpopular/v2/viewed/30.json")
    suspend fun getNewsMonth(
        @Query("api-key") apiKey: String
    ) : NewsResponse

    @GET("news/v3/content/section-list.json")
    suspend fun getNewsSection(
        @Query("api-key") apiKey: String
    ) : SectionListResponse
}