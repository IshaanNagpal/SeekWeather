package com.spdigital.seekweather.model.base


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.spdigital.seekweather.model.base.ErrorModel

@Keep
open class ErrorDataModel(
    @SerializedName("data")
    val data: ErrorModel? = null
)