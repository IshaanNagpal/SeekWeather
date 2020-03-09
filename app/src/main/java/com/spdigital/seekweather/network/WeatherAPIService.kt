package com.spdigital.seekweather.network


import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.model.weather.WeatherDataModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("search.ashx")
    fun fetchLocation(@Query("key") key: String, @Query("format") format: String, @Query("query") query: String): Deferred<Response<LocationModel>>

    @GET("search.ashx")
    fun fetchcurrentWeather(): Deferred<Response<WeatherDataModel>>
}