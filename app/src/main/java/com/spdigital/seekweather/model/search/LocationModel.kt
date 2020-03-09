package com.spdigital.seekweather.model.search


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.spdigital.seekweather.model.base.ErrorDataModel
import com.spdigital.seekweather.model.base.ErrorModel

@Keep
data class LocationModel(
    @SerializedName("search_api")
    val searchApi: SearchApi?
): ErrorDataModel()