package com.example.nytimesapp.sections.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.main.model.Section
import timber.log.Timber

class SectionAdapter(
    private val onClick: (Section) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val sectionData = mutableListOf<Section>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = SectionViewHolder(parent, onClick)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SectionViewHolder -> holder.onBind(item = sectionData[position])
        }
    }

    override fun getItemCount(): Int = sectionData.size


    fun setItems(newList: List<Section>) {
        Timber.tag("###").i("$newList")
        val oldList = ArrayList(sectionData)
        sectionData.clear()
        sectionData.addAll(newList)
        DiffUtil.calculateDiff(getDiffCallback(oldList, newList)).dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldList: List<Section>,
        newList: List<Section>,
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