package com.spdigital.seekweather.model.base


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
open class ErrorModel(
    @SerializedName("error")
    val error: List<Error?>? = listOf()
)