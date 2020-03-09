package com.spdigital.seekweather.di


import com.spdigital.seekweather.repository.LocationRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { LocationRepositoryImpl( get()) }
}