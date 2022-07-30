package com.example.nytimesapp.search.di

import com.example.nytimesapp.search.ui.SearchContract
import com.example.nytimesapp.search.ui.SearchPresenter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object SearchModule {
    fun create() = module {
        singleOf(::SearchPresenter) bind SearchContract.Presenter::class
    }
}