package com.spdigital.seekweather.usecase

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.SearchApi
import com.spdigital.seekweather.view.ListItemModel

interface LocationUseCase {
    suspend fun getLocation(query: String?): Resource<LocationModel>
    fun mapToListItem(searchApi: SearchApi): List<ListItemModel>
}