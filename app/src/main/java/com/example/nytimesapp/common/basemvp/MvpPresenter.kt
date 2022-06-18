package com.example.rawgappv20.common.basemvp

import com.example.nytimesapp.common.basemvp.MvpView

interface MvpPresenter<V : MvpView> {
    fun attach(view: V)
    fun detach()
}