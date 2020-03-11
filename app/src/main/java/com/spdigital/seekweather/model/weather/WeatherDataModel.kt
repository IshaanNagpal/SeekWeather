package com.spdigital.seekweather.model.weather


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherDataModel(
    @SerializedName("ClimateAverages")
    val climateAverages: List<ClimateAverage?>? = listOf(),
    @SerializedName("current_condition")
    val currentCondition: List<CurrentCondition?>? = listOf(),
    @SerializedName("request")
    val request: List<Request?>? = listOf(),
    @SerializedName("weather")
    val weather: List<Weather?>? = listOf()
)