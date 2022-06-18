package com.example.nytimesapp.common.basemvp

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<out V: ViewBinding, I: Item>(
    val binding : V
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: I

    open fun onBind(item: I) {
        this.item = item
    }

    open fun onViewDetached() = Unit
}