package com.spdigital.seekweather.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.spdigital.seekweather.R
import com.spdigital.seekweather.databinding.ActivityWeatherDetailBinding
import com.spdigital.seekweather.viewmodel.WeatherDetailViewModelImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherDetailActivity : BaseActivity() {

    private lateinit var mBinding: ActivityWeatherDetailBinding
    private val weatherDetailViewModelImpl: WeatherDetailViewModelImpl by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_detail)
        mBinding.viewmodel = weatherDetailViewModelImpl
        mBinding.lifecycleOwner = this

        weatherDetailViewModelImpl.getWeatherDetails("New York")
    }
}
