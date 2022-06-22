package com.example.nytimesapp

import android.os.Bundle
import com.example.nytimesapp.common.basemvp.BaseActivity
import com.example.nytimesapp.databinding.ActivityMainBinding
import com.example.nytimesapp.main.ui.fragments.NewsBoardFragment
import com.example.nytimesapp.main.ui.fragments.SectionsFragment
import com.example.nytimesapp.main.ui.fragments.SplashScreenFragment

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val newsBoardFragment = NewsBoardFragment()
    private val splashScreenFragment = SplashScreenFragment()
    private val sectionsFragment = SectionsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        changeFragment(splashScreenFragment, R.id.container)
        changeFragment(sectionsFragment, R.id.container)

    }
}