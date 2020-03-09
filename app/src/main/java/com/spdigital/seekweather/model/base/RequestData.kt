package com.spdigital.seekweather.model.base

import com.spdigital.seekweather.BuildConfig

open class RequestData {
    val key = BuildConfig.API_KEY
    val format = "json"
}