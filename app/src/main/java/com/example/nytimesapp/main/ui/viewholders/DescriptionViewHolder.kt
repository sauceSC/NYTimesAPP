package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapp.databinding.DescriptionArticleItemBinding
import com.example.nytimesapp.main.model.ViewedArticle

class DescriptionViewHolder(
    private val binding: DescriptionArticleItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    constructor(
        parent: ViewGroup
    ) : this(
        DescriptionArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(news: ViewedArticle) = with(binding) {
        tvDescription.text = news.abstract
        tvSection.text = news.section
        tvArticle.text = news.title
        tvDate.text = news.publishedDate
    }
}