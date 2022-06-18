package com.example.nytimesapp.common.basemvp
import androidx.annotation.CallSuper
import com.example.rawgappv20.common.basemvp.MvpPresenter

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {
    protected var view: V? = null
        private set

    @CallSuper
    override fun attach(view: V) {
        this.view = view
    }

    @CallSuper
    override fun detach() {
        view = null
    }

}