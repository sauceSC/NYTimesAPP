package com.example.nytimesapp.common.basemvp


import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.example.rawgappv20.common.basemvp.MvpPresenter

abstract class BaseFragmentMvp<V : MvpView, P : MvpPresenter<V>>(
    @LayoutRes layoutRes: Int
) : BaseFragment(layoutRes), MvpView {
    abstract val presenter: P

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }
}