package com.spdigital.seekweather.usecase

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.spdigital.seekweather.base.CoroutineTest
import com.spdigital.seekweather.model.search.LocationModel
import com.spdigital.seekweather.model.weather.WeatherRequestData
import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.network.ResourceError
import com.spdigital.seekweather.repository.WeatherDetailRepositoryImpl
import kotlinx.coroutines.runBlocking

import org.junit.Assert.*
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock

class WeatherUseCaseImplTest : CoroutineTest() {

    private val repositoryImpl: WeatherDetailRepositoryImpl = declareMock { }
    private val useCaseImpl: WeatherUseCaseImpl by inject()

    @Test
    fun `when asked for locations from the repository, API is called and success is returned`() {
        val successResource = Resource.success(mutableListOf<LocationModel>())
        val weatherRequestData = WeatherRequestData("success")
        //Given
        runBlocking {
            given(repositoryImpl.fetchWeather(weatherRequestData)).will { successResource }
            //When
            val succesRes = useCaseImpl.getWeatherData("success")
            //Then
            verify(repositoryImpl).fetchWeather(weatherRequestData)
            assertEquals(Resource.Status.SUCCESS, succesRes.status)
        }
    }


    @Test
    fun `when asked for locations from the repository, API is called and error is returned`() {
        val successResource = Resource.error<ResourceError>(ResourceError())
        val weatherRequestData = WeatherRequestData("error")
        //Given
        runBlocking {
            given(repositoryImpl.fetchWeather(weatherRequestData)).will { successResource }
            //When
            val succesRes = useCaseImpl.getWeatherData("error")
            //Then
            verify(repositoryImpl).fetchWeather(weatherRequestData)
            assertEquals(Resource.Status.ERROR, succesRes.status)
        }
    }
}