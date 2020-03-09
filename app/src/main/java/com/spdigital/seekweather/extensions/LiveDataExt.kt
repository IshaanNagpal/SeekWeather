package com.spdigital.seekweather.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spdigital.seekweather.view.LiveEvent

fun <T> LiveData<T>.toSingleEvent(): MutableLiveData<T> {
    val result = LiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}