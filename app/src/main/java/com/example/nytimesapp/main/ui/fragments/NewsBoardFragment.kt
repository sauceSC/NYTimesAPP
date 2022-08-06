package com.example.nytimesapp.main.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesapp.R
import com.example.nytimesapp.common.basemvp.BaseFragmentMvp
import com.example.nytimesapp.databinding.FragmentNewsBoardBinding
import com.example.nytimesapp.main.model.ViewedArticle
import com.example.nytimesapp.main.model.search.Doc
import com.example.nytimesapp.main.ui.MainContract
import com.example.nytimesapp.main.ui.adapters.MainBoardAdapter
import com.example.nytimesapp.sections.ui.SectionsFragment
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject

class NewsBoardFragment :
    BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.fragment_news_board),
    MainContract.View{

    override val presenter: MainContract.Presenter by inject()

    private val mainBoardAdapter: MainBoardAdapter by lazy {
        MainBoardAdapter(onClick = { onClickViewedArticle(it) })
    }

    private lateinit var binding: FragmentNewsBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getNewsList(1)
        fab.setOnClickListener { changeFragment(SectionsFragment(), R.id.container) }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.text) {
                    "Day" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(1)
                    }
                    "Week" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(7)

                    }
                    "Month" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(30)

                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when(tab!!.text){
                    "Day" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(1)
                    }
                    "Week" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(7)
                    }
                    "Month" -> {
                        mainBoardAdapter.clearItems()
                        presenter.getNewsList(30)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                mainBoardAdapter.clearItems()
            }

        })
        newsBoard.layoutManager = LinearLayoutManager(context)
        newsBoard.adapter = mainBoardAdapter

    }

    override fun showNews(results: List<ViewedArticle>) {
        mainBoardAdapter.setItems(results)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    private fun onClickViewedArticle(news: ViewedArticle) {
        val fragment =  BrowserFragment()
        val bundle = Bundle()
        bundle.putString("url", news.url)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.container)
    }

}