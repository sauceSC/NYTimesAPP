package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.databinding.DescriptionArticleItemBinding
import com.example.nytimesapp.main.model.ViewedArticle
import com.example.nytimesapp.main.model.search.Doc

class DescriptionViewHolder(
    private val binding: DescriptionArticleItemBinding,
    private val onClick: (ViewedArticle) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        onClick: (ViewedArticle) -> Unit,
    ) : this(
        DescriptionArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick,
    )

    fun onBind(news: ViewedArticle) = with(binding) {
        tvDescription.text = news.abstract
        tvSection.text = news.section
        tvArticle.text = news.title
        tvDate.text = news.publishedDate
        itemView.setOnClickListener { onClick.invoke(news) }
    }
}