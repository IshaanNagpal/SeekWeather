package com.spdigital.seekweather.di

import androidx.room.Room
import com.spdigital.seekweather.persistence.AppDatabase
import com.spdigital.seekweather.persistence.LocationDaoHandlerImpl
import org.koin.dsl.module

val dbModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "locations_db").build() }
    single { get<AppDatabase>().locationsDao() }
    single { LocationDaoHandlerImpl(get()) }
}


val mockDbModule = module {
    single { Room.inMemoryDatabaseBuilder(get(), AppDatabase::class.java).allowMainThreadQueries().build() }
    single { get<AppDatabase>().locationsDao() }
    single { LocationDaoHandlerImpl(get()) }
}