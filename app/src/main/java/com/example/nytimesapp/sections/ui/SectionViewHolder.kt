package com.example.nytimesapp.sections.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesapp.common.basemvp.BaseViewHolder
import com.example.nytimesapp.databinding.SectionItemBinding
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.nytimesapp.main.model.Section
import timber.log.Timber

class SectionViewHolder(
    binding: SectionItemBinding,
    private val onClick: (Section) -> Unit
) : BaseViewHolder<SectionItemBinding, SectionResponse>(binding) {

    constructor(
        parent: ViewGroup,
        onClick: (Section) -> Unit
    ) : this(
        SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick
    )

    fun onBind(item: Section) {
        with(binding){
            tvSectionName.text = item.displayName
            itemView.setOnClickListener { onClick.invoke(item) }
        }
    }

}