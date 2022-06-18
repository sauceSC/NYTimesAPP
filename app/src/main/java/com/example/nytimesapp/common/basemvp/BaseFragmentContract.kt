package com.example.nytimesapp.common.basemvp
import androidx.annotation.AnimRes

interface BaseFragmentContract {
    fun overrideEnterAnimation(@AnimRes animation: Int)
    fun overrideExitAnimation(@AnimRes animation: Int)
}