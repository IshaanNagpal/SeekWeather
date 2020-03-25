package com.spdigital.seekweather.repository

import com.spdigital.seekweather.base.CoroutineTest
import com.spdigital.seekweather.model.search.LocationEntity
import com.spdigital.seekweather.network.WeatherAPIService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock

class LocationRepositoryImplTest : CoroutineTest() {

    private val repositoryImpl: LocationRepositoryImpl by inject()
    private val weatherAPIService: WeatherAPIService = declareMock { }

    private fun getMockLocationEntity(): LocationEntity {
        return LocationEntity("area", "country", "lat", "lon", "pop", "region", "url", 2123432)
    }

    @Test
    fun `when location is added to cache in repository, ensure it saves in DB`() {
        runBlocking {
            assertTrue(repositoryImpl.getCachedLocations().isEmpty())
            val locations = listOf(getMockLocationEntity())
            repositoryImpl.cacheSearchResult(locations)
            assertFalse(repositoryImpl.getCachedLocations().isEmpty())
            assertEquals(locations.size, repositoryImpl.getCachedLocations().size)
        }
    }

//    @Test
//    fun `verify location fetch calls the webservice`() {
//        val successResource = Resource.success(mutableListOf<LocationModel>())
//        val mDeferred = CompletableDeferred<Response<LocationModel>>()
//        //Given
//        //When
//        runBlocking {
////            weatherAPIService.stub {
////                onBlocking { fetchLocationAsync("", "", "") }.doReturn(mDeferred)
////            }
//            given(weatherAPIService.fetchLocationAsync("", "", "").await()).will { mDeferred }
//            repositoryImpl.fetchLocation(LocationRequestData(""))
//
//            //Then
//            verify(weatherAPIService).fetchLocationAsync("", "", "")
//        }
//
//    }
}