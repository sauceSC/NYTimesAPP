package com.example.nytimesapp.sections.di

import com.example.nytimesapp.sections.ui.SectionsContract
import com.example.nytimesapp.sections.ui.SectionsPresenter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object SectionsModule {
    fun create() = module {
        singleOf(::SectionsPresenter) bind SectionsContract.Presenter::class

    }
}