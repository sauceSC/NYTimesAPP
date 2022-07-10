package com.example.nytimesapp.main.ui

import com.example.nytimesapp.common.basemvp.BaseFragmentContract
import com.example.nytimesapp.common.basemvp.MvpView
import com.example.nytimesapp.main.api.model.NewsResponse
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.nytimesapp.main.model.Section
import com.example.nytimesapp.main.model.ViewedArticle
import com.example.rawgappv20.common.basemvp.MvpPresenter

interface MainContract : BaseFragmentContract {
    interface View : MvpView {
        fun showNews(results: List<ViewedArticle>)
        fun showSections(results: List<Section>)
        fun showLoading(isLoading: Boolean)
    }

    interface Presenter: MvpPresenter<View>{
        fun getNewsList(period: Int)
        fun getSectionsList()
    }
}