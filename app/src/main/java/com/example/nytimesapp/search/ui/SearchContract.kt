package com.example.nytimesapp.search.ui

import com.example.nytimesapp.common.basemvp.BaseFragmentContract
import com.example.nytimesapp.common.basemvp.MvpView
import com.example.nytimesapp.main.model.search.Doc
import com.example.nytimesapp.search.ui.SearchContract.*
import com.example.rawgappv20.common.basemvp.MvpPresenter

interface SearchContract : BaseFragmentContract {
    interface View: MvpView{
        fun showNewsBySection(results: List<Doc>?)
        fun showLoading(isLoading: Boolean)
    }

    interface Presenter: MvpPresenter<View> {
        fun getNewsBySection(section: String)
    }
}