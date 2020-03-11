package com.spdigital.seekweather.di


import com.spdigital.seekweather.repository.LocationRepositoryImpl
import com.spdigital.seekweather.repository.WeatherDetailRepository
import com.spdigital.seekweather.repository.WeatherDetailRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { LocationRepositoryImpl(get()) }
    single { WeatherDetailRepositoryImpl(get()) }
}