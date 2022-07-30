package com.example.nytimesapp.sections.ui

import com.example.nytimesapp.common.basemvp.BaseFragmentContract
import com.example.nytimesapp.common.basemvp.MvpView
import com.example.nytimesapp.main.model.Section
import com.example.nytimesapp.main.ui.MainContract
import com.example.nytimesapp.sections.ui.SectionsContract.*
import com.example.rawgappv20.common.basemvp.MvpPresenter

interface SectionsContract : BaseFragmentContract {
    interface View : MvpView {
        fun showSections(results: List<Section>)
    }

    interface Presenter: MvpPresenter<View> {
        fun getSectionsList()
    }
}