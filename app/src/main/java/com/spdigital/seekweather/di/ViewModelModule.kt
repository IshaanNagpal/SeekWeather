package com.spdigital.seekweather.di

import androidx.lifecycle.SavedStateHandle
import com.spdigital.seekweather.viewmodel.SearchLocationViewModelImpl
import com.spdigital.seekweather.viewmodel.WeatherDetailViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchLocationViewModelImpl(get()) }
    viewModel { WeatherDetailViewModelImpl(get()) }
    factory { SavedStateHandle() }
}