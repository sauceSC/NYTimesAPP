package com.example.nytimesapp.search.ui

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
import com.example.nytimesapp.databinding.FragmentBoardBySectionBinding
import com.example.nytimesapp.main.model.search.Doc
import com.example.nytimesapp.main.ui.fragments.BrowserFragment
import com.example.nytimesapp.main.ui.fragments.NewsBoardFragment
import com.example.nytimesapp.sections.ui.SectionsFragment
import org.koin.android.ext.android.inject

class SearchedFragment :
    BaseFragmentMvp<SearchContract.View, SearchContract.Presenter>(R.layout.fragment_board_by_section),
    SearchContract.View {

    override val presenter: SearchContract.Presenter by inject()

    private val searchedBoardAdapter: SearchedBoardAdapter by lazy {
        SearchedBoardAdapter(onClickDoc = {onClickDoc(it)})
    }

    private lateinit var binding: FragmentBoardBySectionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardBySectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        newsBoard.layoutManager = LinearLayoutManager(context)
        newsBoard.adapter = searchedBoardAdapter
        fabHome.setOnClickListener { changeFragment(NewsBoardFragment(), R.id.container) }
        fabSearch.setOnClickListener { changeFragment(SectionsFragment(), R.id.container) }
        val section = arguments?.getString("section")
        presenter.getNewsBySection(section!!)
    }

    override fun showNewsBySection(results: List<Doc>?) {
        searchedBoardAdapter.setItems(results!!)
    }

    override fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }


    private fun onClickDoc(news: Doc){
        val fragment =  BrowserFragment()
        val bundle = Bundle()
        bundle.putString("url", news.webUrl)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.container)
    }

}