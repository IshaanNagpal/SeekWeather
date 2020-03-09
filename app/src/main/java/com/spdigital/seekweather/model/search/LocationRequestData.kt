package com.spdigital.seekweather.model.search

import com.spdigital.seekweather.model.base.RequestData

data class LocationRequestData(private val name: String): RequestData() {
    val query: String = name
}