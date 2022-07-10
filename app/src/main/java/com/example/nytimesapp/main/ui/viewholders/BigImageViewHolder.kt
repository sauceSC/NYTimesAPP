package com.example.nytimesapp.main.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.MainArcticleBinding
import com.example.nytimesapp.main.model.ViewedArticle

class BigImageViewHolder(
    private val binding: MainArcticleBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
    ) : this(
        MainArcticleBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )

    fun onBind(news: ViewedArticle) = with(binding) {
        if(news.media.isNullOrEmpty()) {
            Glide.with(binding.root)
                .load(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        } else {
            Glide.with(binding.root)
                .load(news.media?.get(0)?.mediaMetadata?.get(0)?.url)
                .apply(
                    RequestOptions()
                        .dontTransform()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL)
                )
                .placeholder(R.drawable.ic_nyt_logo)
                .error(R.drawable.ic_nyt_logo)
                .into(ivArticleMainImage)
        }
        tvArticle.text = news.title
        tvDate.text = news.publishedDate
        tvDescription.text = news.abstract
        tvSection.text = news.section
    }

    fun detach() {
        Glide.with(itemView).clear(binding.ivArticleMainImage)
    }
}