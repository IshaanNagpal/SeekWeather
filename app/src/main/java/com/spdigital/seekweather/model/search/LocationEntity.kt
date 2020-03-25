package com.spdigital.seekweather.model.search


import androidx.annotation.Keep
import androidx.room.Entity

@Keep
@Entity(tableName = "location", primaryKeys = ["areaName", "region", "country"])
class LocationEntity(
    val areaName: String,
    val country: String,
    val latitude: String,
    val longitude: String,
    val population: String,
    val region: String,
    val weatherUrl: String,
    val time: Long
)