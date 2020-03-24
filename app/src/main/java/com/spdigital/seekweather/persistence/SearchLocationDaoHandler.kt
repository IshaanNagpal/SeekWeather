package com.spdigital.seekweather.persistence

import com.spdigital.seekweather.model.search.LocationEntity


interface SearchLocationDaoHandler {
    suspend fun getLocationsFromDB(): MutableList<LocationEntity>
    suspend fun isLocationTableEmpty(): Boolean
    suspend fun addLocationsIntoDB(gitReposModelList: List<LocationEntity>?)
}