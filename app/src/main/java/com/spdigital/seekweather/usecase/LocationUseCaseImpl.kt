package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.model.search.SearchApi
import com.spdigital.seekweather.repository.LocationRepositoryImpl
import com.spdigital.seekweather.view.ListItemModel
import com.spdigital.seekweather.view.SearchLocationItemView

class LocationUseCaseImpl(private val locationRepositoryImpl: LocationRepositoryImpl): LocationUseCase {
    override suspend fun getLocation(query: String?): Resource<LocationModel> {
        return locationRepositoryImpl.fetchLocation(LocationRequestData(query ?:""))
    }

    override fun mapToListItem(searchApi: SearchApi): List<ListItemModel> {
        val locationsItemViewList = mutableListOf<ListItemModel>()
        searchApi.result.let {
            it?.map { result ->
                locationsItemViewList.add(SearchLocationItemView(result)) }
        }
        return locationsItemViewList
    }
}