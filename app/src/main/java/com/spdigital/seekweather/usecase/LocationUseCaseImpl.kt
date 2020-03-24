package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.extensions.getLocationEntity
import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.model.search.ResultModel
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.repository.LocationRepositoryImpl
import com.spdigital.seekweather.utility.CACHE_SIZE
import com.spdigital.seekweather.view.ListItemModel
import com.spdigital.seekweather.view.SearchLocationItemView

class LocationUseCaseImpl(private val locationRepositoryImpl: LocationRepositoryImpl): LocationUseCase {

    override suspend fun getLocation(query: String?): Resource<LocationModel> {
        return locationRepositoryImpl.fetchLocation(LocationRequestData(query ?:""))
    }

    override suspend fun mapToListItem(results: List<ResultModel?>?, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel> {
        val locationsItemViewList = mutableListOf<ListItemModel>()
        results.let {
            it?.map { result ->
                locationsItemViewList.add(SearchLocationItemView(result.getLocationEntity(), itemClickCallback)) }
        }
        return locationsItemViewList
    }

    override suspend fun saveLocationToLocalCache(resultModel: LocationEntity) {
        val cachedLocations = locationRepositoryImpl.getCachedLocations()
        if(cachedLocations.size >= CACHE_SIZE) {
            cachedLocations.sortByDescending { it.time }
            cachedLocations.removeAt(cachedLocations.size-1)
        }
        cachedLocations.add(resultModel)
        locationRepositoryImpl.cacheSearchResult(cachedLocations)
    }

    override suspend fun getSortedRecentlySearchedLocations(): List<LocationEntity> {
        val list = locationRepositoryImpl.getCachedLocations()
        list.sortByDescending {
            it.time
        }

        return list
    }

    override suspend fun mapRecentlySearchedLocationToListItem(locations: List<LocationEntity>?, itemClickCallback: (LocationEntity?) -> Unit): List<ListItemModel> {
        val locationsItemViewList = mutableListOf<ListItemModel>()
        locations?.let { it.map {result -> locationsItemViewList.add(SearchLocationItemView(result, itemClickCallback)) } }
        return locationsItemViewList
    }
}