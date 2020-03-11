package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.LiveData
import com.spdigital.seekweather.model.weather.WeatherDataModel
import com.spdigital.seekweather.view.ListItemModel

interface WeatherDetailViewModel {
    fun getWeatherDetails(location: String)
    fun getWeatherLiveData(): LiveData<WeatherDataModel>
}