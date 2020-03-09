package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.weather.WeatherDataModel
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.repository.WeatherDetailRepository

class WeatherUseCaseImpl(private val repository: WeatherDetailRepository): WeatherUseCase {
    override fun getWeatherData(): Resource<WeatherDataModel> {
        return repository.fetchWeather(WeatherRequestData())
    }
}