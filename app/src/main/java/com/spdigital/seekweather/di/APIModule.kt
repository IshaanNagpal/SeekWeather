package com.spdigital.seekweather.di


import com.spdigital.seekweather.network.WeatherAPIService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module{
    single { get<Retrofit>().create(WeatherAPIService::class.java) }
}