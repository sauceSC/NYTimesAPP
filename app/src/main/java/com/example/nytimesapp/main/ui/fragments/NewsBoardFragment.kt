package com.example.nytimesapp.main.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nytimesapp.R
import com.example.nytimesapp.common.basemvp.BaseFragmentMvp
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.nytimesapp.main.ui.MainContract
import org.koin.android.ext.android.inject
import timber.log.Timber

class NewsBoardFragment :
    BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.fragment_news_board),
    MainContract.View{

    override val presenter: MainContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getNewsList(1)
    }

    override fun showNews(results: List<ViewedArticleResponse>) {

    }

    override fun showSections(results: List<SectionResponse>) {

    }

}