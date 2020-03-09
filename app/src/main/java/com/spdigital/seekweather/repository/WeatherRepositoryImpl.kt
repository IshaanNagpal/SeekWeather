package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.WeatherDataModel
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.network.WeatherAPIService

class WeatherRepositoryImpl(private val weatherAPIService: WeatherAPIService) : WeatherDetailRepository {
    override fun fetchWeather(weatherRequestData: WeatherRequestData): Resource<WeatherDataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}