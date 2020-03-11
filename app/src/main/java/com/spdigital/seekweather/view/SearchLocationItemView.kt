package com.spdigital.seekweather.view

import com.spdigital.seekweather.R
import com.spdigital.seekweather.model.search.ResultModel

class SearchLocationItemView(
    private val resultModel: ResultModel?,
    private val itemClickCallback: (ResultModel?) -> Unit
) : ListItemModel {

    val location =
        resultModel?.areaName?.get(0)?.value + ", " + resultModel?.region?.get(0)?.value + ", " + resultModel?.country?.get(
            0
        )?.value

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