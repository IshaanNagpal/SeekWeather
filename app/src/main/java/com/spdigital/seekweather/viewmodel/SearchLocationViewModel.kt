package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.MutableLiveData
import com.spdigital.seekweather.view.ListItemModel

interface SearchLocationViewModel {
    fun observeForLiveData(): MutableLiveData<List<ListItemModel>>
    fun getSearchedLocation(newText: String?)
}