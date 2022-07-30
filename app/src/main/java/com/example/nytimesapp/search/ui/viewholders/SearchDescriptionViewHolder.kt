package com.example.nytimesapp.search.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.databinding.DescriptionArticleItemBinding
import com.example.nytimesapp.main.model.search.Doc

class SearchDescriptionViewHolder(
    private val binding: DescriptionArticleItemBinding,
    private val onClickDoc: (Doc) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        onClickDoc: (Doc) -> Unit
    ) : this(
        DescriptionArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickDoc,
    )

    fun onBind(news: Doc) = with(binding) {
        tvDescription.text = news.abstract
        tvSection.text = news.sectionName
        tvArticle.text = news.headline.main
        tvDate.isVisible = false
        itemView.setOnClickListener { onClickDoc.invoke(news) }
    }
}