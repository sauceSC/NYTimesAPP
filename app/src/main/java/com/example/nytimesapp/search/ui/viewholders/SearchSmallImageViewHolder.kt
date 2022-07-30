package com.example.nytimesapp.search.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.SmallImageArticleBinding
import com.example.nytimesapp.main.model.ViewedArticle
import com.example.nytimesapp.main.model.search.Doc
import com.example.nytimesapp.utils.Constants

class SearchSmallImageViewHolder (
    private val binding: SmallImageArticleBinding,
    private val onClickDoc: (Doc) -> Unit
) : RecyclerView.ViewHolder(binding.root){

    constructor(
        parent: ViewGroup,
        onClickDoc: (Doc) -> Unit
    ) : this(
        SmallImageArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickDoc,
    )

    fun onBind(news: Doc) = with(binding){
        if (news.multimedia.isNullOrEmpty()){
            Glide.with(binding.root)
                .load(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        } else {
            Glide.with(binding.root)
                .load("${Constants.NYT_BASE_URL}${news.multimedia[0].url}")
                .placeholder(R.drawable.ic_nyt_logo)
                .error(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        }
        tvArticle.text = news.headline.main
        tvDate.isVisible = false
        tvDescription.text = news.abstract
        tvSectionName.text = news.sectionName
        itemView.setOnClickListener { onClickDoc.invoke(news) }
    }


    fun detach() {
        Glide.with(itemView).clear(binding.ivArticleMainImage)
    }

}