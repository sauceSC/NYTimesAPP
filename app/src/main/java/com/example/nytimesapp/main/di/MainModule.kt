package com.example.nytimesapp.main.di

import com.example.nytimesapp.main.interactor.NewsInteractor
import com.example.nytimesapp.main.model.Section
import com.example.nytimesapp.main.repository.NewsRemoteRepository
import com.example.nytimesapp.main.ui.MainContract
import com.example.nytimesapp.main.ui.NewsPresenter
import com.example.nytimesapp.sections.ui.SectionsContract
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        singleOf(::NewsPresenter) bind MainContract.Presenter::class
        factoryOf(::NewsInteractor)
        singleOf(::NewsRemoteRepository)
    }
}