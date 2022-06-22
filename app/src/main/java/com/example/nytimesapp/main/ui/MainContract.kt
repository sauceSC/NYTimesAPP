package com.example.nytimesapp.main.ui

import com.example.nytimesapp.common.basemvp.BaseFragmentContract
import com.example.nytimesapp.common.basemvp.MvpView
import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.rawgappv20.common.basemvp.MvpPresenter

interface MainContract : BaseFragmentContract {
    interface View : MvpView {
        fun showNews(results: List<ViewedArticleResponse>)
        fun showSections(results: List<SectionResponse>)
    }

    interface Presenter: MvpPresenter<View>{
        fun getNewsList(period: Int)
        fun getSectionsList()
    }
}