package com.spdigital.seekweather.model.search


import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "location")
data class LocationEntity(
    @PrimaryKey
    @field: SerializedName("area")
    val areaName: String,
    @field: SerializedName("country")
    val country: String,
    @field: SerializedName("lat")
    val latitude: String,
    @field: SerializedName("lon")
    val longitude: String,
    @field: SerializedName("population")
    val population: String,
    @field: SerializedName("region")
    val region: String,
    @field: SerializedName("weatherUrl")
    val weatherUrl: String,
    @field: SerializedName("timestamp")
    val time: Long
)