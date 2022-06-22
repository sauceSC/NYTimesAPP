package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesapp.common.basemvp.BaseViewHolder
import com.example.nytimesapp.databinding.SectionItemBinding
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse

class SectionViewHolder(
    binding: SectionItemBinding
) : BaseViewHolder<SectionItemBinding, SectionResponse>(binding) {

    constructor(
        parent: ViewGroup
    ) : this(
        SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBind(item: SectionResponse) {
        with(binding){
            tvSectionName.text = item.displayName

        }
    }

}