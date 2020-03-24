package com.spdigital.seekweather.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spdigital.seekweather.model.search.LocationEntity


@Dao
interface LocationsDao {

    @Query("SELECT * from `location`")
    suspend fun getAllCachedLocations(): MutableList<LocationEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(reposLIst: List<LocationEntity>)

    @Query("DELETE from `location`")
    suspend fun deleteAll()
}