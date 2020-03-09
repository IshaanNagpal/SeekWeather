package com.spdigital.seekweather.model.base


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Error(
    @SerializedName("msg")
    val msg: String? = ""
)