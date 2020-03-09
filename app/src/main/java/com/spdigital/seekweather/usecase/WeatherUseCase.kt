package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.WeatherDataModel

interface WeatherUseCase {
    fun getWeatherData(): Resource<WeatherDataModel>
}