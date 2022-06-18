package com.example.nytimesapp.common.basemvp


import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.example.rawgappv20.common.basemvp.MvpPresenter


abstract class BaseActivityMvp<V: MvpView, P: MvpPresenter<V>> : AppCompatActivity(), MvpView {
    abstract val presenter: P

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}