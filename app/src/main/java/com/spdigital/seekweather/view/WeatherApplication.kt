package com.spdigital.seekweather.view

import androidx.multidex.MultiDexApplication
import com.spdigital.seekweather.di.networkModule
import com.spdigital.seekweather.di.repositoryModule
import com.spdigital.seekweather.di.viewModelModule
import com.spdigital.seekweather.di.apiModule
import com.spdigital.seekweather.di.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class WeatherApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApplication)
            modules(listOf(viewModelModule, usecaseModule, repositoryModule, networkModule, apiModule))
        }


    }


    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}