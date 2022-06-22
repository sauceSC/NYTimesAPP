package com.example.nytimesapp.main.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesapp.R
import com.example.nytimesapp.common.basemvp.BaseFragmentMvp
import com.example.nytimesapp.databinding.FragmentSectionsBinding
import com.example.nytimesapp.databinding.SectionItemBinding
import com.example.nytimesapp.main.api.model.SectionResponse
import com.example.nytimesapp.main.api.model.ViewedArticleResponse
import com.example.nytimesapp.main.ui.MainContract
import com.example.nytimesapp.main.ui.adapters.SectionAdapter
import org.koin.android.ext.android.inject

class SectionsFragment : BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.fragment_sections), MainContract.View {

    private val sectionAdapter: SectionAdapter by lazy{
        SectionAdapter()
    }
    private lateinit var binding: FragmentSectionsBinding

    override val presenter: MainContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getSectionsList()
        sectionsRecycler.layoutManager = LinearLayoutManager(context)
        sectionsRecycler.adapter = sectionAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun showNews(results: List<ViewedArticleResponse>) {
        TODO("Not yet implemented")
    }

    override fun showSections(results: List<SectionResponse>) {
        sectionAdapter.setItems(results)
    }


}