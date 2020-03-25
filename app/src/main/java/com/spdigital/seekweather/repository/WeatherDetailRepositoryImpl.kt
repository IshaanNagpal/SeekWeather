package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.CurrentWeatherResponse
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.network.WeatherAPIService
import com.spdigital.seekweather.utility.AppUtility

class WeatherDetailRepositoryImpl(private val weatherAPIService: WeatherAPIService, appUtility: AppUtility) : BaseRepository(appUtility), WeatherDetailRepository {
    override suspend fun fetchWeather(weatherRequestData: WeatherRequestData): Resource<CurrentWeatherResponse> {
        return safeApiCall(call = {
            weatherAPIService.fetchcurrentWeatherAsync(weatherRequestData.key, weatherRequestData.format, weatherRequestData.q, weatherRequestData.date).await()
        })
    }
}