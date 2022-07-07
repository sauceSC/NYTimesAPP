package com.example.nytimesapp.main.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.nytimesapp.R

fun Fragment.replaceFragment(fragment: Fragment) {
    val fragmentManager = requireActivity().supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.addToBackStack(null)
        .replace(R.id.container, fragment)
        .commit()
}