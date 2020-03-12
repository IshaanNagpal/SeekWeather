package com.spdigital.seekweather.view

import com.sample.gitrepos.extensions.filterNull
import com.spdigital.seekweather.R
import com.spdigital.seekweather.model.search.ResultModel
import java.lang.StringBuilder

class SearchLocationItemView(
    private val resultModel: ResultModel?,
    private val itemClickCallback: (ResultModel?) -> Unit
) : ListItemModel {

    val location = getFormattedLocation()

    private fun getFormattedLocation(): String {

        var strBuilder = StringBuilder()
        if(resultModel?.areaName?.get(0)?.value.filterNull().trim().isNotEmpty()) {
            strBuilder.append(resultModel?.areaName?.get(0)?.value)
        }
        if(resultModel?.region?.get(0)?.value.filterNull().trim().isNotEmpty()) {
            strBuilder.append(", " + resultModel?.region?.get(0)?.value)
        }
        if(resultModel?.country?.get(0)?.value.filterNull().trim().isNotEmpty()) {
            strBuilder.append(", " + resultModel?.country?.get(0)?.value)
        }

        return strBuilder.toString()
    }


    override fun layoutId(): Int {
        return R.layout.search_list_item
    }

    fun invokeItemClick() {
        itemClickCallback.invoke(resultModel)
    }

    override fun data(): Any? {
        return resultModel
    }


}