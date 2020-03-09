package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.WeatherDataModel
import com.spdigital.seekweather.model.weather.WeatherRequestData

interface WeatherDetailRepository {
    fun fetchWeather(weatherRequestData: WeatherRequestData): Resource<WeatherDataModel>
}