package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.MainArcticleBinding
import com.example.nytimesapp.databinding.SmallImageArticleBinding
import com.example.nytimesapp.main.model.MediaMetadata
import com.example.nytimesapp.main.model.ViewedArticle

class SmallImageViewHolder(
    private val binding: SmallImageArticleBinding
) : RecyclerView.ViewHolder(binding.root){

    constructor(
        parent: ViewGroup,
    ) : this(
        SmallImageArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )

    fun onBind(news: ViewedArticle) = with(binding){
        if(news.media.isNullOrEmpty()) {
            Glide.with(binding.root)
                .load(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        } else {
            Glide.with(binding.root)
                .load(news.media?.get(0)?.mediaMetadata?.get(0)?.url)
                .placeholder(R.drawable.ic_nyt_logo)
                .error(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        }
        tvArticle.text = news.title
        tvDate.text = news.publishedDate
        tvDescription.text = news.abstract
        tvSectionName.text = news.section
    }

    fun detach() {
        Glide.with(itemView).clear(binding.ivArticleMainImage)
    }

}