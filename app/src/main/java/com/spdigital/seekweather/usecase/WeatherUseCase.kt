package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.CurrentWeatherResponse

interface WeatherUseCase {
    suspend fun getWeatherData(location: String): Resource<CurrentWeatherResponse>
}