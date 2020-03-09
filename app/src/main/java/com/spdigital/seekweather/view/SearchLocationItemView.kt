package com.spdigital.seekweather.view

import com.spdigital.seekweather.R
import com.spdigital.seekweather.model.search.Result

class SearchLocationItemView(private val result: Result?) : ListItemModel {

    val location = result?.areaName?.get(0)?.value + ", " +result?.region?.get(0)?.value + ", "+ result?.country?.get(0)?.value

    override fun layoutId(): Int {
        return R.layout.search_list_item
    }

}