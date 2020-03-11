package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.gitrepos.extensions.filterNull
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.extensions.toSingleEvent
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.ResultModel
import com.spdigital.seekweather.usecase.LocationUseCaseImpl
import com.spdigital.seekweather.view.ListItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchLocationViewModelImpl(private val locationUseCaseImpl: LocationUseCaseImpl) :
    BaseViewModel(), SearchLocationViewModel {
    private val locationsLiveData by lazy { MutableLiveData<List<ListItemModel>>().toSingleEvent() }
    private val navigateLiveData by lazy { MutableLiveData<String>().toSingleEvent() }

    override fun observeForLocationsList(): MutableLiveData<List<ListItemModel>> {
        return locationsLiveData
    }

    override fun observeForNavigator(): MutableLiveData<String> {
        return navigateLiveData
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
                        val mapToListItem = locationUseCaseImpl.mapToListItem(
                            locationModel.searchApi,
                            getItemClickCallback()
                        )
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

    private fun getItemClickCallback(): (Any?) -> Unit {
        return {
            if (it != null && it is ResultModel)
                navigateLiveData.value = it.areaName?.get(0)?.value.filterNull()
        }
    }

}