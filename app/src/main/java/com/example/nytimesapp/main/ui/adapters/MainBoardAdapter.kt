package com.example.nytimesapp.main.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.R
import com.example.nytimesapp.main.model.ViewedArticle
import com.example.nytimesapp.main.ui.viewholders.BigImageViewHolder
import com.example.nytimesapp.main.ui.viewholders.SmallImageViewHolder

class MainBoardAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val news = mutableListOf<ViewedArticle>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.main_arcticle -> BigImageViewHolder(parent)
            R.layout.small_image_article -> SmallImageViewHolder(parent)
            else -> throw IllegalStateException("Something went wrong in MainBoardAdapter")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BigImageViewHolder -> holder.onBind(
                news[position],
            )
            is SmallImageViewHolder -> holder.onBind(
                news[position],
            )
            else -> throw IllegalStateException("Something went wrong in $position")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> R.layout.main_arcticle
            else -> R.layout.small_image_article
        }
    }

    override fun getItemCount(): Int = news.size

    fun setItems(newList: List<ViewedArticle>){
        val oldList = ArrayList(news)
        news.clear()
        news.addAll(newList)
        DiffUtil.calculateDiff(getDiffCallback(oldList, newList)).dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldList: List<ViewedArticle>,
        newList: List<ViewedArticle>,
    ) = object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val old = oldList[oldItemPosition]
            val new = newList[newItemPosition]
            return old == new
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size
    }

    fun clearItems() {
        val itemsCount = news.size
        news.clear()
        notifyItemRangeRemoved(0, itemsCount)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        when(holder){
            is BigImageViewHolder -> holder.detach()
            is SmallImageViewHolder -> holder.detach()
        }
    }
}