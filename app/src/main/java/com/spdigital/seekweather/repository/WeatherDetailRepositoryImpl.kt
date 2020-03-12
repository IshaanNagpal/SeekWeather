package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.CurrentWeatherResponse
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.network.WeatherAPIService

class WeatherDetailRepositoryImpl(private val weatherAPIService: WeatherAPIService) : BaseRepository(), WeatherDetailRepository {
    override suspend fun fetchWeather(weatherRequestData: WeatherRequestData): Resource<CurrentWeatherResponse> {
        return safeApiCall(call = {
            weatherAPIService.fetchcurrentWeatherAsync(weatherRequestData.key, weatherRequestData.format, weatherRequestData.q, weatherRequestData.date).await()
        })
    }
}