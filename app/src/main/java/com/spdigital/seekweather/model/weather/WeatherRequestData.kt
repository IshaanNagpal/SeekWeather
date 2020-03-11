package com.spdigital.seekweather.model.weather

import com.spdigital.seekweather.model.base.RequestData

data class WeatherRequestData(val q: String): RequestData() {
val date = "today"
}