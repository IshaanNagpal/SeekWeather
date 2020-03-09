package com.spdigital.seekweather.di

import com.spdigital.seekweather.usecase.LocationUseCaseImpl
import com.spdigital.seekweather.usecase.WeatherUseCaseImpl
import org.koin.dsl.module

val usecaseModule = module {
    factory { LocationUseCaseImpl(get()) }
    factory { WeatherUseCaseImpl(get()) }
}