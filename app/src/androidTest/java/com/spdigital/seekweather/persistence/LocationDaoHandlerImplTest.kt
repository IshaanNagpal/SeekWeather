package com.spdigital.seekweather.persistence

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.spdigital.seekweather.base.AndroidBaseTest
import com.spdigital.seekweather.model.search.LocationEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.inject


@RunWith(AndroidJUnit4ClassRunner::class)
class LocationDaoHandlerImplTest: AndroidBaseTest() {

    private val daoHandlerImpl: LocationDaoHandlerImpl by inject()
    private val appDB: AppDatabase by inject()

    @Test
    fun checkForInsertionIntoDBWithEmptyData() = runBlocking {
        daoHandlerImpl.addLocationsIntoDB(mutableListOf())
        Assert.assertTrue(daoHandlerImpl.isLocationTableEmpty())
        Assert.assertTrue(daoHandlerImpl.getLocationsFromDB().isEmpty())
    }

    @Test
    fun checkForInsertionIntoDBWithNull() = runBlocking {
        daoHandlerImpl.addLocationsIntoDB(null)
        Assert.assertTrue(daoHandlerImpl.isLocationTableEmpty())
        Assert.assertTrue(daoHandlerImpl.getLocationsFromDB().isEmpty())
    }

    @Test
    fun checkForInsertionIntoDBWithValidData() = runBlocking {
        val reposList = mutableListOf(getMockLocationEntity())
        daoHandlerImpl.addLocationsIntoDB(reposList)
        Assert.assertFalse(daoHandlerImpl.isLocationTableEmpty())
        Assert.assertTrue(daoHandlerImpl.getLocationsFromDB().isNotEmpty())
        Assert.assertEquals(getMockLocationEntity().areaName, daoHandlerImpl.getLocationsFromDB()[0].areaName)
        Assert.assertEquals(getMockLocationEntity().time, daoHandlerImpl.getLocationsFromDB()[0].time)
    }


    private fun getMockLocationEntity(): LocationEntity {
        return LocationEntity("area", "country", "lat", "lon", "pop", "region", "url", 2123432)
    }

    @After
    fun afterEach() {
        appDB.close()
    }

}
