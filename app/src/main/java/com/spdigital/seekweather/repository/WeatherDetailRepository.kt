package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.CurrentWeatherResponse
import com.spdigital.seekweather.model.weather.WeatherRequestData

interface WeatherDetailRepository {
    suspend fun fetchWeather(weatherRequestData: WeatherRequestData): Resource<CurrentWeatherResponse>
}