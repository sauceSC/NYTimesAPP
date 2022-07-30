package com.example.nytimesapp.search.ui

import com.example.nytimesapp.common.basemvp.BasePresenter
import com.example.nytimesapp.main.interactor.NewsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchPresenter(
    private val newsInteractor: NewsInteractor
) : BasePresenter<SearchContract.View>(), SearchContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getNewsBySection(section: String) {
        presenterScope.launch {
            try {
                view?.showLoading(true)
                val data = newsInteractor.getNewsBySections("section_name:(\"$section\")")
                view?.showNewsBySection(data.response.docs)
            } catch (t: Throwable){
                Timber.e(t.message)
            } finally {
                view?.showLoading(false)
            }
        }
    }
}