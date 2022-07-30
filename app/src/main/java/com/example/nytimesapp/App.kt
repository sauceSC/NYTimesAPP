package com.example.nytimesapp

import android.app.Application
import com.example.nytimesapp.main.di.MainModule
import com.example.nytimesapp.main.main.CommonModule
import com.example.nytimesapp.search.di.SearchModule
import com.example.nytimesapp.sections.di.SectionsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        setupKoin()
    }

    private fun setupKoin(){
        startKoin {
            androidContext(this@App)
            modules(
                CommonModule.createRetrofit(),
                MainModule.create(),
                SectionsModule.create(),
                SearchModule.create()
            )

        }
    }
}