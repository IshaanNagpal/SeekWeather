package com.spdigital.seekweather.model.weather

import com.spdigital.seekweather.model.base.RequestData

data class WeatherRequestData(val location: String) : RequestData() {
    val q = location
    val date = "today"
}