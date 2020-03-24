package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.ResultModel
import com.spdigital.seekweather.view.ListItemModel

interface LocationUseCase {
    suspend fun getLocation(query: String?): Resource<LocationModel>
    suspend fun mapToItemViewList(results: List<ResultModel?>?, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel>
    suspend fun saveLocationToLocalCache(resultModel: LocationEntity)
    suspend fun getSortedRecentlySearchedLocations(): List<LocationEntity>
    suspend fun mapRecentlySearchedLocationToListItem(locations: List<LocationEntity>?, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel>
}