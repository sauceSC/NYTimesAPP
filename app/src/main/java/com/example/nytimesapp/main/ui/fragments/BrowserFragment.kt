package com.example.nytimesapp.main.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.FragmentBrowserBinding

class BrowserFragment : Fragment(R.layout.fragment_browser){
    private val binding: FragmentBrowserBinding by lazy{
        FragmentBrowserBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(binding){
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("url")
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(url!!)
    }

}