package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.model.weather.CurrentWeatherResponse
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.repository.WeatherDetailRepositoryImpl

class WeatherUseCaseImpl(private val repository: WeatherDetailRepositoryImpl): WeatherUseCase {
    override suspend fun getWeatherData(location: String): Resource<CurrentWeatherResponse> {
        return repository.fetchWeather(WeatherRequestData(location))
    }
}