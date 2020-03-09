package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData

interface LocationRepository {
    suspend fun fetchLocation(locationRequestData: LocationRequestData): Resource<LocationModel>
}