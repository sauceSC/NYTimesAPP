package com.example.nytimesapp.search.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.R
import com.example.nytimesapp.main.model.search.Doc
import com.example.nytimesapp.main.ui.viewholders.BigImageViewHolder
import com.example.nytimesapp.main.ui.viewholders.SmallImageViewHolder
import com.example.nytimesapp.search.ui.viewholders.SearchBigImageViewHolder
import com.example.nytimesapp.search.ui.viewholders.SearchDescriptionViewHolder
import com.example.nytimesapp.search.ui.viewholders.SearchSmallImageViewHolder

class SearchedBoardAdapter(
    private val onClickDoc: (Doc) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private val news = mutableListOf<Doc>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            R.layout.description_article_item -> SearchDescriptionViewHolder(parent, onClickDoc)
            R.layout.main_arcticle -> SearchBigImageViewHolder(parent, onClickDoc)
            R.layout.small_image_article -> SearchSmallImageViewHolder(parent, onClickDoc)
            else -> throw IllegalStateException("Something went wrong in MainBoardAdapter")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchBigImageViewHolder -> holder.onBind(news[position])
            is SearchSmallImageViewHolder -> holder.onBind(news[position])
            is SearchDescriptionViewHolder -> holder.onBind(news[position])
            else -> throw IllegalStateException("Something went wrong in $position")
        }
    }

    override fun getItemCount(): Int = news.size

    fun setItems(newList: List<Doc>){
        val oldList = ArrayList(news)
        news.clear()
        news.addAll(newList)
        DiffUtil.calculateDiff(getDiffCallback(oldList, newList)).dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldList: List<Doc>,
        newList: List<Doc>,
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

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> if (news[position].multimedia.isNullOrEmpty()) {
                R.layout.description_article_item
            } else {
                R.layout.main_arcticle
            }
            else -> if (news[position].multimedia.isNullOrEmpty()) {
                R.layout.description_article_item
            } else {
                R.layout.small_image_article
            }
        }
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