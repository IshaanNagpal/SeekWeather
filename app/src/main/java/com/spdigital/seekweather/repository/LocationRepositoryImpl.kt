package com.spdigital.seekweather.repository

import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.network.WeatherAPIService
import com.spdigital.seekweather.persistence.LocationDaoHandlerImpl
import com.spdigital.seekweather.utility.AppUtility

class LocationRepositoryImpl(private val weatherAPIService: WeatherAPIService, private val locationDaoHandlerImpl: LocationDaoHandlerImpl, appUtility: AppUtility): BaseRepository(appUtility), LocationRepository {
    override suspend fun fetchLocation(locationRequestData: LocationRequestData): Resource<LocationModel> {
        return safeApiCall(call = {
        weatherAPIService.fetchLocationAsync(locationRequestData.key, locationRequestData.format, locationRequestData.query).await()
    })
    }

    override suspend fun cacheSearchResult(locations: List<LocationEntity>) {
        locationDaoHandlerImpl.addLocationsIntoDB(locations)
    }

    override suspend fun getCachedLocations(): MutableList<LocationEntity> {
        return locationDaoHandlerImpl.getLocationsFromDB()
    }
}