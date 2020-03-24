package com.spdigital.seekweather.usecase

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.spdigital.seekweather.base.CoroutineTest
import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.search.LocationRequestData
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.network.ResourceError
import com.spdigital.seekweather.repository.LocationRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock

class LocationUseCaseImplTest : CoroutineTest() {


    private val repositoryImpl: LocationRepositoryImpl = declareMock { }
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
    fun `verify to save the location in local cache`() {
        val locations = mutableListOf(getMockLocationEntity())
        runBlocking {
            //Given
            given(repositoryImpl.getCachedLocations()).willReturn(mutableListOf())
            //When
            useCaseImpl.saveLocationToLocalCache(getMockLocationEntity())
            //Then
            verify(repositoryImpl).getCachedLocations()
            Assert.assertTrue(useCaseImpl.getRecentlySearchedLocations().isNotEmpty())
        }
    }

    fun getMockLocationEntity(): LocationEntity {
        return LocationEntity("area", "country", "lat", "lon", "pop", "region", "url", 2123432)
    }

}