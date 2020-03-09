package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.LiveData
import com.spdigital.seekweather.view.ListItemModel

interface WeatherDetailViewModel {
    fun getWeatherDetails(): LiveData<ListItemModel>
}