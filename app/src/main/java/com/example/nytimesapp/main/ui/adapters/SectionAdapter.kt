package com.example.nytimesapp.main.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.R
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.ui.viewholders.SectionViewHolder

class SectionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val sectionData = mutableListOf<SectionResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.fragment_sections -> SectionViewHolder(parent)
            else -> throw IllegalStateException("Unknown viewtype: $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SectionViewHolder -> holder.onBind(item = sectionData[position])
        }
    }

    override fun getItemCount(): Int = sectionData.size

    override fun getItemViewType(position: Int): Int = when (position) {
            else -> R.layout.fragment_sections
        }


    fun setItems(newList: List<SectionResponse>) {
        val oldList = ArrayList(sectionData)
        sectionData.clear()
        sectionData.addAll(newList)
        notifyDataSetChanged()
        DiffUtil.calculateDiff(getDiffCallback(oldList, newList)).dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldList: List<SectionResponse>,
        newList: List<SectionResponse>,
    ) = object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.section == newItem.section
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val old = oldList[oldItemPosition]
            val new = newList[newItemPosition]
            return old == new
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size
    }

}