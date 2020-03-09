package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.LiveData
import com.spdigital.seekweather.usecase.WeatherUseCaseImpl
import com.spdigital.seekweather.view.ListItemModel

class WeatherDetailViewModelImpl(private val useCaseImpl: WeatherUseCaseImpl): BaseViewModel(), WeatherDetailViewModel {
    override fun getWeatherDetails(): LiveData<ListItemModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}