package com.example.nytimesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.nytimesapp.common.basemvp.BaseActivity
import com.example.nytimesapp.databinding.ActivityMainBinding
import com.example.nytimesapp.main.ui.fragments.NewsBoardFragment

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val newsBoardFragment = NewsBoardFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeFragment(newsBoardFragment, R.id.container)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        clearBackStack()
    }
}