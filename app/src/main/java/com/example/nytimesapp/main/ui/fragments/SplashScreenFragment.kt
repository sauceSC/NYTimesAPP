package com.example.nytimesapp.main.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.SplashScreenBinding


class SplashScreenFragment : Fragment(R.layout.splash_screen){
    private val binding: SplashScreenBinding by lazy {
        SplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding){
        return root
    }
}