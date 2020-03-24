package com.spdigital.seekweather.usecase

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.spdigital.seekweather.base.CoroutineTest
import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.network.ResourceError
import com.spdigital.seekweather.persistence.LocationDaoHandlerImpl
import com.spdigital.seekweather.repository.LocationRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock

class LocationUseCaseImplTest : CoroutineTest() {


    private val repositoryImpl: LocationRepositoryImpl = declareMock { }
    private val locationDaoHandlerImpl: LocationDaoHandlerImpl = declareMock { }
    private val useCaseImpl: LocationUseCaseImpl by inject()

    @Test
    fun `when asked for locations from the repository, API is called and success is return`() {
        val successResource = Resource.success(mutableListOf<LocationModel>())
        val successLocationData = LocationRequestData("success")
        //Given
        runBlocking {
            given(repositoryImpl.fetchLocation(locationRequestData = successLocationData)).will { successResource }
            //When
            val succesRes = useCaseImpl.getLocation("success")
            //Then
            verify(repositoryImpl).fetchLocation(successLocationData)
            assertEquals(Resource.Status.SUCCESS, succesRes.status)
        }
    }


    @Test
    fun `when asked for locations from the repository, API is called and error is return`() {
        val errorResource = Resource.error<ResourceError>(ResourceError())
        val errorLocationData = LocationRequestData("error")
        //Given
        runBlocking {
            given(repositoryImpl.fetchLocation(locationRequestData = errorLocationData)).will { errorResource }
            //When
            val errorRes = useCaseImpl.getLocation("error")
            //Then
            verify(repositoryImpl).fetchLocation(errorLocationData)
            assertEquals(Resource.Status.ERROR, errorRes.status)
        }
    }


    @Test
    fun `verify to save the location in local cache, when cache is not full`() {
        val locations = mutableListOf<LocationEntity>()
        runBlocking {
            //Given
            given(repositoryImpl.getCachedLocations()).willReturn(locations)
            locationDaoHandlerImpl.stub {
                onBlocking { getLocationsFromDB() }.doReturn(locations)
            }
            //When
            useCaseImpl.saveLocationToLocalCache(getMockLocationEntity())
            //Then
            verify(repositoryImpl).getCachedLocations()   //Verify the method is called
            val cachedLocations = useCaseImpl.getSortedRecentlySearchedLocations()
            assertFalse(cachedLocations.isNullOrEmpty())
            assertEquals(locations.size, cachedLocations.size)
            assertEquals(getMockLocationEntity().areaName, cachedLocations[0].areaName)
            assertEquals(getMockLocationEntity().time, cachedLocations[0].time)
        }
    }

    @Test
    fun `verify to save the location in local cache, when cache is full`() {
        val locations = mutableListOf<LocationEntity>()
        val updatedMockLocation = LocationEntity("Area", "Country", "lat", "lon", "pop", "region",
            "url", 2123433)
        for (index in 1..10) {
            locations.add(getMockLocationEntity())
        }

        runBlocking {
            //Given
            given(repositoryImpl.getCachedLocations()).willReturn(locations)
            locationDaoHandlerImpl.stub {
                onBlocking { getLocationsFromDB() }.doReturn(locations)
            }
            //When
            useCaseImpl.saveLocationToLocalCache(updatedMockLocation)
            //Then
            verify(repositoryImpl).getCachedLocations()   //Verify the method is called
            val cachedLocations = useCaseImpl.getSortedRecentlySearchedLocations()
            assertFalse(cachedLocations.isNullOrEmpty())
            assertEquals(locations.size, cachedLocations.size)                              //Verify the list size remains 10
            assertEquals(updatedMockLocation.areaName, cachedLocations[0].areaName)         //Verify the updated item is at top of the list
            assertEquals(updatedMockLocation.time, cachedLocations[0].time)
        }
    }


    private fun getMockLocationEntity(): LocationEntity {
        return LocationEntity("area", "country", "lat", "lon", "pop", "region", "url", 2123432)
    }

}