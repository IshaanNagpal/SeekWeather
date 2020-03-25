package com.spdigital.seekweather.base

import androidx.test.core.app.ApplicationProvider
import com.spdigital.seekweather.di.mockDbModule
import com.spdigital.seekweather.view.WeatherApplication
import org.junit.After
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest

open class AndroidBaseTest: AutoCloseKoinTest() {
    private val reposApplicationContext = ApplicationProvider.getApplicationContext<WeatherApplication>()

    @Before
    fun beforeEach() {

        if(GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(reposApplicationContext)
                modules(listOf(mockDbModule))
            }
        }
    }

    @After
    fun tearDown() {
        autoClose()
    }
}