package com.spdigital.seekweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.spdigital.seekweather.extensions.toSingleEvent
import com.spdigital.seekweather.model.weather.WeatherDataModel
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.usecase.WeatherUseCaseImpl
import com.spdigital.seekweather.view.ListItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherDetailViewModelImpl(private val useCaseImpl: WeatherUseCaseImpl) : BaseViewModel(),
    WeatherDetailViewModel {

    lateinit var locationName: String
    lateinit var weather: String
    lateinit var tempInCelcius: String
    lateinit var tempInFahreneits: String
    lateinit var humidity: String

    private val currentWeatherLiveData by lazy { MutableLiveData<List<ListItemModel>>().toSingleEvent() }

    override fun getWeatherDetails(location: String) {

        viewModelScope.launch(Dispatchers.Main) {
            val weatherResource = useCaseImpl.getWeatherData(location)

            when (weatherResource.status) {
                Resource.Status.SUCCESS -> {
                }
                Resource.Status.ERROR -> {
                }
            }
        }
    }

    override fun getWeatherLiveData(): LiveData<WeatherDataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}