package com.spdigital.seekweather.extensions

import com.sample.gitrepos.extensions.filterNull
import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.model.search.ResultModel

fun ResultModel?.getLocationEntity(): LocationEntity {

    return LocationEntity(
        areaName = this?.areaName?.get(0)?.value.filterNull(),
        country = this?.country?.get(0)?.value.filterNull(),
        latitude = this?.latitude.filterNull(),
        longitude = this?.longitude.filterNull(),
        population = this?.population.filterNull(),
        region = this?.region?.get(0)?.value.filterNull(),
        weatherUrl = this?.weatherUrl?.get(0)?.value.filterNull(),
        time = System.currentTimeMillis()
    )
}
