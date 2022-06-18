package com.example.nytimesapp.main.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesAPI {
    @GET("svc/mostpopular/v2/viewed")
    fun getNewsToday(
        @Query("1.json") day: Int,
        @Query("api-key") apiKey: String
    )

    @GET("svc/mostpopular/v2/viewed")
    fun getNewsWeek(
        @Query("7.json") day: Int,
        @Query("api-key") apiKey: String
    )

    @GET("svc/mostpopular/v2/viewed")
    fun getNewsMonth(
        @Query("30.json") day: Int,
        @Query("api-key") apiKey: String
    )
}