package com.spdigital.seekweather.view

import com.sample.gitrepos.extensions.filterNull
import com.spdigital.seekweather.R
import com.spdigital.seekweather.model.search.LocationEntity
import java.lang.StringBuilder

class SearchLocationItemView(
    private val locationEntity: LocationEntity?,
    private val itemClickCallback: (LocationEntity?) -> Unit
) : ListItemModel {

    val location = getFormattedLocation()

    private fun getFormattedLocation(): String {

        val strBuilder = StringBuilder()
        if(locationEntity?.areaName.filterNull().trim().isNotEmpty()) {
            strBuilder.append(locationEntity?.areaName)
        }
        if(locationEntity?.region.filterNull().trim().isNotEmpty()) {
            strBuilder.append(", " + locationEntity?.region)
        }
        if(locationEntity?.country.filterNull().trim().isNotEmpty()) {
            strBuilder.append(", " + locationEntity?.country)
        }
        return strBuilder.toString()
    }


    override fun layoutId(): Int {
        return R.layout.search_list_item
    }

    fun invokeItemClick() {
        itemClickCallback.invoke(locationEntity)
    }

    override fun data(): Any? {
        return locationEntity
    }


}