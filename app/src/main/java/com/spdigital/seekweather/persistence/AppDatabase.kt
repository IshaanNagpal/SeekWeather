package com.spdigital.seekweather.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spdigital.seekweather.model.search.LocationEntity

@Database(entities = [LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationsDao(): LocationsDao
}