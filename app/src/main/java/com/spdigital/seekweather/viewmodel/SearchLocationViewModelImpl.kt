package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.extensions.toSingleEvent
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.usecase.LocationUseCaseImpl
import com.spdigital.seekweather.view.ListItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchLocationViewModelImpl(private val locationUseCaseImpl: LocationUseCaseImpl) :
    BaseViewModel(), SearchLocationViewModel {
    private val locationsLiveData = MutableLiveData<List<ListItemModel>>().toSingleEvent()

    override fun observeForLiveData(): MutableLiveData<List<ListItemModel>> {
        return locationsLiveData
    }

    override fun getSearchedLocation(query: String?) {
        setLoading()
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)
            val resource = locationUseCaseImpl.getLocation(query)
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    val locationModel = resource.data as LocationModel
                    if (locationModel.searchApi == null) {
                        setError()
                    } else {
                        val mapToListItem = locationUseCaseImpl.mapToListItem(locationModel.searchApi)
                        locationsLiveData.value = mapToListItem
                        setSuccess()
                    }
                }
                Resource.Status.ERROR -> {
                    setError()
                }
            }
        }
    }

}