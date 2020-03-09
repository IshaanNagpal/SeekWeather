package com.spdigital.seekweather.model.search


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.spdigital.seekweather.model.search.Region
import com.spdigital.seekweather.model.search.AreaName
import com.spdigital.seekweather.model.search.Country
import com.spdigital.seekweather.model.search.WeatherUrl

@Keep
data class Result(
    @SerializedName("areaName")
    val areaName: List<AreaName?>? = listOf(),
    @SerializedName("country")
    val country: List<Country?>? = listOf(),
    @SerializedName("latitude")
    val latitude: String? = "",
    @SerializedName("longitude")
    val longitude: String? = "",
    @SerializedName("population")
    val population: String? = "",
    @SerializedName("region")
    val region: List<Region?>? = listOf(),
    @SerializedName("weatherUrl")
    val weatherUrl: List<WeatherUrl?>? = listOf()
)