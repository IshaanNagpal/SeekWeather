package com.spdigital.seekweather.view

import androidx.multidex.MultiDexApplication
import com.spdigital.seekweather.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class WeatherApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApplication)
            modules(listOf(viewModelModule, usecaseModule, repositoryModule, networkModule, apiModule, dbModule))
        }


    }


    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}