package com.example.nytimesapp.sections.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesapp.R
import com.example.nytimesapp.common.basemvp.BaseFragmentMvp
import com.example.nytimesapp.databinding.FragmentSectionsBinding
import com.example.nytimesapp.main.model.Section
import com.example.nytimesapp.search.ui.SearchedFragment
import org.koin.android.ext.android.inject

class SectionsFragment : BaseFragmentMvp<SectionsContract.View, SectionsContract.Presenter>(R.layout.fragment_sections), SectionsContract.View {

    private val sectionAdapter: SectionAdapter by lazy{
        SectionAdapter(onClick = { onClick(it) } )
    }
    private lateinit var binding: FragmentSectionsBinding

    override val presenter: SectionsContract.Presenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        sectionsRecycler.layoutManager = LinearLayoutManager(context)
        sectionsRecycler.adapter = sectionAdapter
        presenter.getSectionsList()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun showSections(results: List<Section>) {
        sectionAdapter.setItems(results)
    }

    private fun onClick(section : Section){
        val fragment =  SearchedFragment()
        val bundle = Bundle()
        bundle.putString("section", section.displayName)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.container)
    }

}