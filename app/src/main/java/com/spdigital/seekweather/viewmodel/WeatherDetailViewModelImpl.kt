package com.spdigital.seekweather.viewmodel

import androidx.databinding.ObservableField
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

    var locationName = ObservableField<String>()
    var weather = ObservableField<String>()
    var tempInCelcius = ObservableField<String>()
    var tempInFahreneits = ObservableField<String>()
    var humidity = ObservableField<String>()

    private val currentWeatherLiveData by lazy { MutableLiveData<List<ListItemModel>>().toSingleEvent() }

    override fun getWeatherDetails(location: String) {

        viewModelScope.launch(Dispatchers.Main) {
            val weatherResource = useCaseImpl.getWeatherData(location)

            when (weatherResource.status) {
                Resource.Status.SUCCESS -> {
                    locationName.set(location)
//                    weather.set(weatherResource.data?.data?.currentCondition?.get(0)?.weatherDesc?.get(0)?.value)
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