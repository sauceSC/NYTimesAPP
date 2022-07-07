package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesapp.common.basemvp.BaseViewHolder
import com.example.nytimesapp.databinding.SectionItemBinding
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.nytimesapp.main.model.Section

class SectionViewHolder(
    binding: SectionItemBinding
) : BaseViewHolder<SectionItemBinding, SectionResponse>(binding) {

    constructor(
        parent: ViewGroup
    ) : this(
        SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: Section) {
        with(binding){
            tvSectionName.text = item.displayName
        }
    }

}