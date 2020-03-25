package com.spdigital.seekweather.di

import com.spdigital.seekweather.utility.AppUtility
import org.koin.dsl.module

val utilityModule = module {
    single { AppUtility(get()) }
}