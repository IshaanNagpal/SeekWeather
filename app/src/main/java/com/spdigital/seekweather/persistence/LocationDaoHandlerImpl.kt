package com.spdigital.seekweather.persistence

import com.spdigital.seekweather.model.search.LocationEntity

class LocationDaoHandlerImpl(private val locationsDao: LocationsDao) : SearchLocationDaoHandler {
    override suspend fun getLocationsFromDB(): MutableList<LocationEntity> {
        return locationsDao.getAllCachedLocations() ?: mutableListOf()
    }

    override suspend fun isLocationTableEmpty(): Boolean {
        return locationsDao.getAllCachedLocations().isNullOrEmpty()
    }

    override suspend fun addLocationsIntoDB(locations: List<LocationEntity>?) {
        locations?.let {
            locationsDao.deleteAll()
            locationsDao.insertLocations(locations)
        }
    }

}