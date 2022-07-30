package com.example.nytimesapp.sections.ui

import com.example.nytimesapp.common.basemvp.BasePresenter
import com.example.nytimesapp.main.interactor.NewsInteractor
import com.example.nytimesapp.main.ui.MainContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class SectionsPresenter(
    private val newsInteractor: NewsInteractor
) : BasePresenter<SectionsContract.View>(), SectionsContract.Presenter {
    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getSectionsList() {
        presenterScope.launch {
            try {
                val data = newsInteractor.getSectionResults()
                view?.showSections(data.section)
            } catch (t: Throwable) {
                Timber.e(t.message)
            }
        }
    }

}