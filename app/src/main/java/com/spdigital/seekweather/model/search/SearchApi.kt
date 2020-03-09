package com.spdigital.seekweather.model.search


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SearchApi(
    @SerializedName("result")
    val result: List<Result?>? = listOf()
)