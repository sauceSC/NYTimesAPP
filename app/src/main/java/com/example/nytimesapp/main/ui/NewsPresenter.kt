package com.example.nytimesapp.main.ui

import com.example.nytimesapp.common.basemvp.BasePresenter
import com.example.nytimesapp.main.interactor.NewsInteractor
import kotlinx.coroutines.*
import timber.log.Timber

class NewsPresenter(
    private val newsInteractor: NewsInteractor
) : BasePresenter<MainContract.View>(), MainContract.Presenter {
    private var job : Job = Job()
    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getNewsList(period: Int) {
        presenterScope.launch {
            try {
                val data = newsInteractor.getNewsResults(period)
                view?.showNews(data.results!!)
            } catch (t: Throwable){
                Timber.e(t.message)
            }
        }
    }

    override fun getSectionsList(){
        presenterScope.launch {
            try {
                val data = newsInteractor.getSectionResults()
                view?.showSections(data.section!!)
            } catch (t: Throwable){
                Timber.e(t.message)
            }
        }
    }


}