package com.spdigital.seekweather.model.weather


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Weather(
    @SerializedName("astronomy")
    val astronomy: List<Astronomy?>? = listOf(),
    @SerializedName("avgtempC")
    val avgtempC: String? = "",
    @SerializedName("avgtempF")
    val avgtempF: String? = "",
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("hourly")
    val hourly: List<Hourly?>? = listOf(),
    @SerializedName("maxtempC")
    val maxtempC: String? = "",
    @SerializedName("maxtempF")
    val maxtempF: String? = "",
    @SerializedName("mintempC")
    val mintempC: String? = "",
    @SerializedName("mintempF")
    val mintempF: String? = "",
    @SerializedName("sunHour")
    val sunHour: String? = "",
    @SerializedName("totalSnow_cm")
    val totalSnowCm: String? = "",
    @SerializedName("uvIndex")
    val uvIndex: String? = ""
)