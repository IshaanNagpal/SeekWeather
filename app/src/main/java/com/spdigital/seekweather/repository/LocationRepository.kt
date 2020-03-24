package com.spdigital.seekweather.repository

import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.model.search.ResultModel

interface LocationRepository {
    suspend fun fetchLocation(locationRequestData: LocationRequestData): Resource<LocationModel>
    suspend fun cacheSearchResult(locations: List<LocationEntity>)
    suspend fun getCachedLocations(): MutableList<LocationEntity>
}