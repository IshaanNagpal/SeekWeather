package com.spdigital.seekweather.network


import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.weather.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("search.ashx")
    fun fetchLocationAsync(@Query("key") key: String, @Query("format") format: String, @Query("query") query: String):
            Deferred<Response<LocationModel>>

    @GET("weather.ashx")
    fun fetchcurrentWeatherAsync(
        @Query("key") key: String, @Query("format") format: String, @Query("q")location: String, @Query("date")date: String):
            Deferred<Response<CurrentWeatherResponse>>
}