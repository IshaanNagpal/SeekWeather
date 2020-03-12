package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.network.WeatherAPIService

class LocationRepositoryImpl(private val weatherAPIService: WeatherAPIService): BaseRepository(), LocationRepository {
    override suspend fun fetchLocation(locationRequestData: LocationRequestData): Resource<LocationModel> {
        return safeApiCall(call = {
        weatherAPIService.fetchLocationAsync(locationRequestData.key, locationRequestData.format, locationRequestData.query).await()
    })
    }
}