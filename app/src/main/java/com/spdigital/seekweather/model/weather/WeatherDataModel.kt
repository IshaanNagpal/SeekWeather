package com.spdigital.seekweather.model.weather


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.spdigital.seekweather.model.base.ErrorModel

@Keep
data class WeatherDataModel(
    @SerializedName("data")
    val `data`: Data? = Data()
): ErrorModel()