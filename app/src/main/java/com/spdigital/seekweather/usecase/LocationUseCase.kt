package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.ResultModel
import com.spdigital.seekweather.model.search.SearchApi
import com.spdigital.seekweather.view.ListItemModel

interface LocationUseCase {
    suspend fun getLocation(query: String?): Resource<LocationModel>
    suspend fun mapToListItem(searchApi: SearchApi, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel>
    suspend fun saveLocationToLocalCache(resultModel: LocationEntity)
    suspend fun getRecentlySearchedLocations(): List<LocationEntity>
    suspend fun mapRecentlySearchedLocationToListItem(locations: List<LocationEntity>?, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel>
}