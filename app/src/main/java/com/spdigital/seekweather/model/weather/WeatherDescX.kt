package com.spdigital.seekweather.model.weather


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherDescX(
    @SerializedName("value")
    val value: String? = ""
)