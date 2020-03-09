package com.spdigital.seekweather.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

open class BaseViewModel() : ViewModel() {


    private val loadingStateLiveData by lazy { ObservableField<Boolean>() }
    private val successStateLiveData by lazy { ObservableField<Boolean>() }
    private val errorStateLiveData by lazy { ObservableField<Boolean>() }


    fun isLoadingState(): ObservableField<Boolean> = loadingStateLiveData
    fun isSuccessState(): ObservableField<Boolean> = successStateLiveData
    fun isErrorState(): ObservableField<Boolean> = errorStateLiveData


    fun setSuccess() {
        loadingStateLiveData.set(false)
        successStateLiveData.set(true)
        errorStateLiveData.set(false)
    }

    fun setError() {
        loadingStateLiveData.set(false)
        successStateLiveData.set(false)
        errorStateLiveData.set(true)
    }

    fun setLoading() {
        loadingStateLiveData.set(true)
        successStateLiveData.set(false)
        errorStateLiveData.set(false)
    }

}