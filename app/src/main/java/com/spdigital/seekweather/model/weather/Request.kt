package com.spdigital.seekweather.model.weather


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Request(
    @SerializedName("query")
    val query: String? = "",
    @SerializedName("type")
    val type: String? = ""
)